package io.xxnjdg.notp.user.service;

import io.xxnjdg.notp.user.object.persistent.Platform;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 平台信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface PlatformService extends IService<Platform> {

    /**
     * 通过 clientId 查找 platform
     * @param clientId
     * @return
     */
    Platform getPlatformByClientId(String clientId);
}
