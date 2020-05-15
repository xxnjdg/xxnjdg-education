package io.xxnjdg.notp.user.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.xxnjdg.notp.system.apis.SysUserControllerApi;
import io.xxnjdg.notp.system.objects.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.objects.view.SysUserVO;
import io.xxnjdg.notp.user.config.SnowFlakeId;
import io.xxnjdg.notp.user.object.data.transfer.UserLogLoginDTO;
import io.xxnjdg.notp.user.object.data.transfer.UserLoginPasswordDTO;
import io.xxnjdg.notp.user.object.data.transfer.UserRegisterDTO;
import io.xxnjdg.notp.user.object.error.PlatformEnum;
import io.xxnjdg.notp.user.object.error.UserEnum;
import io.xxnjdg.notp.user.object.error.UserRegisterEnum;
import io.xxnjdg.notp.user.object.persistent.Platform;
import io.xxnjdg.notp.user.object.persistent.User;
import io.xxnjdg.notp.user.mapper.UserMapper;
import io.xxnjdg.notp.user.object.persistent.UserExt;
import io.xxnjdg.notp.user.object.view.UserLoginVO;
import io.xxnjdg.notp.user.service.PlatformService;
import io.xxnjdg.notp.user.service.UserExtService;
import io.xxnjdg.notp.user.service.UserLogLoginService;
import io.xxnjdg.notp.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.RedisPrefixField;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.JWTUtil;
import io.xxnjdg.notp.utils.custom.utils.NOUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private PlatformService platformService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Autowired
    private UserExtService userExtService;

    @Autowired
    private UserLogLoginService userLogLoginService;

    @Autowired
    private SysUserControllerApi sysUserControllerApi;

    @Override
    public UserLoginVO postUserLoginByPassword(UserLoginPasswordDTO userLoginPasswordDTO) {

        String clientId = userLoginPasswordDTO.getClientId();

        //判断平台是否存在
        platformService.getPlatformByClientId(clientId);

        LambdaQueryWrapper<User> userQueryWrapper = new QueryWrapper<User>()
                .lambda()
                .eq(User::getStatusId, RowStatus.ENABLE)
                .eq(User::getMobile, userLoginPasswordDTO.getMobile());


        //查询 user
        User user = this.getOne(userQueryWrapper);

        //不存在
        if (user == null){
            throw new BaseException(UserEnum.USER_OR_PASSWORD_ERROR);
        }

        Long userNo = user.getUserNo();

        //判断密码是否正确
        if (!ObjectUtil.equal(
                DigestUtil.sha1Hex(user.getMobileSalt() + userLoginPasswordDTO.getPassword())
                ,user.getMobilePsw()
        )){
            throw new BaseException(UserEnum.USER_OR_PASSWORD_ERROR);
        }

        if (userLoginPasswordDTO.getAdmin()!=null && userLoginPasswordDTO.getAdmin()){
            ResponseResult<SysUserVO> result = sysUserControllerApi
                    .listMenuApiUrl(new SysUserDTO().setUserNo(userNo));

            if (result==null ||
                    !ObjectUtil.equal(result.getStatus(),HttpStatus.SUCCESS.getStatus()) ||
                    result.getData() == null ||
                    CollUtil.isEmpty(result.getData().getListMenuApiUrl())){
                throw new BaseException(UserEnum.USER_OR_PASSWORD_ERROR);
            }
            String jsonString = JSONUtils.toJSONString(result.getData().getListMenuApiUrl());
            stringRedisTemplate.opsForValue().set(RedisPrefixField.AUTHORITY_PREFIX+userNo,jsonString,30, TimeUnit.MINUTES);
        }

        //插入登录状态
        UserLogLoginDTO userLogLoginDTO = new UserLogLoginDTO()
                .setLoginStatus(1)
                .setUserNo(userNo)
                .setClientId(clientId);

        userLogLoginService.insertUserLogLogin(userLogLoginDTO);

        //生成jwt
        String jwt = JWTUtil.create(userNo, JWTUtil.DATE);
        stringRedisTemplate.opsForValue().set(RedisPrefixField.LOGIN_PREFIX+userNo.toString(),jwt,30, TimeUnit.MINUTES);

        //返回
        return new UserLoginVO(
                userNo,
                user.getMobile(),
                jwt
        );
    }

    @Override
    @Transactional
    public UserLoginVO postUserRegister(UserRegisterDTO userRegisterDTO) {
        check(userRegisterDTO);

        //查询手机号是否注册
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new QueryWrapper<User>().lambda()
                .eq(User::getMobile, userRegisterDTO.getMobile());

        User one = this.getOne(userLambdaQueryWrapper);
        if (one != null){
            throw new BaseException(UserRegisterEnum.REGISTER_ERROR);
        }

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long userId = snowflake.nextId();
        long userExtId = snowflake.nextId();

        //生成密码盐
        String mobileSalt = IdUtil.simpleUUID();

        //生成密码
        String mobilePsw = DigestUtil.sha1Hex(mobileSalt + userRegisterDTO.getPassword());

        //生成密码 userNo
        Long userNo = NOUtil.getUserNo();

        //插入 user 表
        User user = new User()
                .setId(userId)
                .setGmtCreate(LocalDateTime.now())
                .setGmtModified(LocalDateTime.now())
                .setUserSource(userRegisterDTO.getClientId())
                .setMobile(userRegisterDTO.getMobile())
                .setStatusId(RowStatus.ENABLE)
                .setMobileSalt(mobileSalt)
                .setMobilePsw(mobilePsw)
                .setUserNo(userNo);

        if (!this.save(user)){
            throw new BaseException(UserRegisterEnum.INSERT_ERROR);
        }

        //插入 userExt 表
        UserExt userExt = new UserExt()
                .setId(userExtId)
                .setGmtCreate(LocalDateTime.now())
                .setGmtModified(LocalDateTime.now())
                .setMobile(userRegisterDTO.getMobile())
                .setStatusId(RowStatus.ENABLE)
                .setUserNo(userNo)
                .setUserType(1);

        if (!userExtService.save(userExt)){
            throw new BaseException(UserRegisterEnum.INSERT_ERROR);
        }

        return new UserLoginVO(
                user.getUserNo(),
                user.getMobile(),
                JWTUtil.create(user.getUserNo(),JWTUtil.DATE)
        );
    }

    private void check(UserRegisterDTO userRegisterDTO) {
        //判断密码是否相同
        if (!ObjectUtil.equal(userRegisterDTO.getPassword(),userRegisterDTO.getRepassword())){
            throw new BaseException(UserRegisterEnum.PASSWORD_REPEAT_ERROR);
        }

        //获取验证码
        String code = stringRedisTemplate.opsForValue().get(RedisPrefixField.VERIFY_PREFIX + userRegisterDTO.getMobile());

        //验证码为空
        if (code == null){
            throw new BaseException(UserRegisterEnum.CODE_ERROR);
        }

        //验证码不正确
        if (!ObjectUtil.equal(code,userRegisterDTO.getCode())){
            throw new BaseException(UserRegisterEnum.CODE_ERROR);
        }

        //判断平台是否存在
        platformService.getPlatformByClientId(userRegisterDTO.getClientId());
    }

    @Override
    public Boolean updateUserPassword(UserRegisterDTO userRegisterDTO) {
        check(userRegisterDTO);

        //查询手机号是否注册
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new QueryWrapper<User>().lambda()
                .eq(User::getMobile, userRegisterDTO.getMobile());

        User one = this.getOne(userLambdaQueryWrapper);

        if (one == null){
            throw new BaseException(UserRegisterEnum.USER_NO_REGISTER_ERROR);
        }

        //判断元密码和心密码是否一致
        String oldMobileSalt = one.getMobileSalt();

        //生成密码
        String mobilePsw = DigestUtil.sha1Hex(oldMobileSalt + userRegisterDTO.getPassword());

        if (StrUtil.equals(mobilePsw,one.getMobilePsw())){
            throw new BaseException(UserRegisterEnum.USER_PASSWORD_EQUAL_ERROR);
        }

        //生成密码盐
        String mobileSalt = IdUtil.simpleUUID();

        //生成密码
        mobilePsw = DigestUtil.sha1Hex(mobileSalt + userRegisterDTO.getPassword());

        LambdaUpdateWrapper<User> wrapper = new UpdateWrapper<User>()
                .lambda()
                .eq(User::getMobile, userRegisterDTO.getMobile())
                .set(User::getMobilePsw, mobilePsw)
                .set(User::getMobileSalt, mobileSalt)
                .set(User::getGmtModified, LocalDateTime.now());

        boolean update = this.update(wrapper);

        if (!update){
            throw new BaseException(UserRegisterEnum.USER_PASSWORD_INSERT_ERROR);
        }

        return true;
    }
}
