package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.WebsiteNavArticleBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteNavArticleDTO;
import io.xxnjdg.notp.system.object.persistent.WebsiteNavArticle;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 22:57
 */
public interface WebsiteNavArticleAdminService extends IService<WebsiteNavArticle> {

    /**
     * 查询
     * @return
     */
    List<WebsiteNavArticleBO> listWebsiteNavArticle();

    /**
     * 查询
     * @param websiteNavArticleDTO
     * @return
     */
    WebsiteNavArticleBO getWebsiteNavArticleByNavId(WebsiteNavArticleDTO websiteNavArticleDTO);

    /**
     * 更新
     * @param websiteNavArticleDTO
     * @return
     */
    Boolean updateWebsiteNavArticleById(WebsiteNavArticleDTO websiteNavArticleDTO);
}
