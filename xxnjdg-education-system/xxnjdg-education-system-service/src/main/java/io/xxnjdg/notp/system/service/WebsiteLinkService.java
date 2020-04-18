package io.xxnjdg.notp.system.service;

import io.xxnjdg.notp.system.object.persistent.WebsiteLink;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.object.view.WebsiteLinkVO;

import java.util.List;

/**
 * <p>
 * 站点友情链接 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface WebsiteLinkService extends IService<WebsiteLink> {

    /**
     *  ss
     * @return
     */
    List<WebsiteLinkVO> postWebsiteLinkList();
}
