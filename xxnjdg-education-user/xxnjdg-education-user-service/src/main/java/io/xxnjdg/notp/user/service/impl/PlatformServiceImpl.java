package io.xxnjdg.notp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.user.object.error.PlatformEnum;
import io.xxnjdg.notp.user.object.persistent.Platform;
import io.xxnjdg.notp.user.mapper.PlatformMapper;
import io.xxnjdg.notp.user.service.PlatformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 平台信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Service
public class PlatformServiceImpl extends ServiceImpl<PlatformMapper, Platform> implements PlatformService {

    @Override
    public Platform getPlatformByClientId(String clientId) {
        LambdaQueryWrapper<Platform> platformQueryWrapper = new QueryWrapper<Platform>()
                .lambda()
                .eq(Platform::getClientId, clientId)
                .eq(Platform::getStatusId, RowStatus.ENABLE);

        Platform platform = this.getOne(platformQueryWrapper);

        if (platform == null){
            throw new BaseException(PlatformEnum.CLIENT_ID_ERROR);
        }
        return platform;
    }
}
