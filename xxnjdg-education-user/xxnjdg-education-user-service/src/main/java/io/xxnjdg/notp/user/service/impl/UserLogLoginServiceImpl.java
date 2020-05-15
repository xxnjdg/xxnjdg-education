package io.xxnjdg.notp.user.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import io.xxnjdg.notp.user.config.SnowFlakeId;
import io.xxnjdg.notp.user.object.convert.UserLogLoginMapStruct;
import io.xxnjdg.notp.user.object.data.transfer.UserLogLoginDTO;
import io.xxnjdg.notp.user.object.error.UserLogLoginEnum;
import io.xxnjdg.notp.user.object.persistent.UserLogLogin;
import io.xxnjdg.notp.user.mapper.UserLogLoginMapper;
import io.xxnjdg.notp.user.service.UserLogLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户错误登录日志 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Service
public class UserLogLoginServiceImpl extends ServiceImpl<UserLogLoginMapper, UserLogLogin> implements UserLogLoginService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public Boolean insertUserLogLogin(UserLogLoginDTO userLogLoginDTO) {
        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        userLogLoginDTO.setId(id);

        UserLogLogin userLogLogin = UserLogLoginMapStruct.INSTANCE.convertDTO2D(userLogLoginDTO);

        boolean save = this.save(userLogLogin);
        if (!save){
            throw new BaseException(UserLogLoginEnum.INSERT_ERROR);
        }
        return null;
    }
}
