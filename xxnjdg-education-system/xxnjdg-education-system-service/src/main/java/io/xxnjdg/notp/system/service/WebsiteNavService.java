package io.xxnjdg.notp.system.service;

import io.xxnjdg.notp.system.object.domain.WebsiteNavLevelDo;
import io.xxnjdg.notp.system.object.persistent.WebsiteNav;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.object.view.WebsiteNavLevelVo;

import java.util.List;

/**
 * <p>
 * 站点导航 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface WebsiteNavService extends IService<WebsiteNav> {

    /**
     * 返回
     * @return List<WebsiteNavLevelVo>
     */
    List<WebsiteNavLevelVo> getWebsiteNavLevelList();
}
