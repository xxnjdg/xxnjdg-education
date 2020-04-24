package io.xxnjdg.notp.user.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.user.object.data.transfer.UserLoginPasswordDTO;
import io.xxnjdg.notp.user.object.error.PlatformEnum;
import io.xxnjdg.notp.user.object.error.UserEnum;
import io.xxnjdg.notp.user.object.persistent.Platform;
import io.xxnjdg.notp.user.object.persistent.User;
import io.xxnjdg.notp.user.mapper.UserMapper;
import io.xxnjdg.notp.user.object.view.UserLoginVO;
import io.xxnjdg.notp.user.service.PlatformService;
import io.xxnjdg.notp.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.JWTUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public UserLoginVO postUserLoginByPassword(UserLoginPasswordDTO userLoginPasswordDTO) {

        LambdaQueryWrapper<Platform> platformQueryWrapper = new QueryWrapper<Platform>()
                .lambda()
                .eq(Platform::getClientId, userLoginPasswordDTO.getClientId())
                .eq(Platform::getStatusId, RowStatus.ENABLE);

        Platform platform = platformService.getOne(platformQueryWrapper);

        if (platform == null){
            throw new BaseException(PlatformEnum.CLIENT_ID_ERROR);
        }

        LambdaQueryWrapper<User> userQueryWrapper = new QueryWrapper<User>()
                .lambda()
                .eq(User::getStatusId, RowStatus.ENABLE)
                .eq(User::getMobile, userLoginPasswordDTO.getMobile());


        User user = this.getOne(userQueryWrapper);

        if (user == null){
            throw new BaseException(UserEnum.USER_OR_PASSWORD_ERROR);
        }

        if (!ObjectUtil.equal(
                DigestUtil.sha1Hex(user.getMobileSalt() + userLoginPasswordDTO.getPassword())
                ,user.getMobilePsw()
        )){
            throw new BaseException(UserEnum.USER_OR_PASSWORD_ERROR);
        }


        return new UserLoginVO(
                user.getUserNo(),
                user.getMobile(),
                JWTUtil.create(user.getUserNo(),JWTUtil.DATE)
        );
    }
}
