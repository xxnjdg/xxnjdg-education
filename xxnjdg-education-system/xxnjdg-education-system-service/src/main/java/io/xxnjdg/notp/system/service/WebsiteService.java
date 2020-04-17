package io.xxnjdg.notp.system.service;

import io.xxnjdg.notp.system.object.persistent.Website;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.object.view.WebsiteVo;

/**
 * <p>
 * 站点信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface WebsiteService extends IService<Website> {

    /**
     * k
     * @return
     */
    WebsiteVo postWebsite();
}
