package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.WebsiteNavArticleBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteNavArticleDTO;
import io.xxnjdg.notp.system.admin.object.view.WebsiteNavArticleVO;
import io.xxnjdg.notp.system.object.persistent.WebsiteNavArticle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 23:00
 */
@Mapper
public interface WebsiteNavArticleMapStruct {
    WebsiteNavArticleMapStruct INSTANCE = Mappers.getMapper(WebsiteNavArticleMapStruct.class);

    /**
     * P2B
     * @param websiteNavArticleDTO
     * @return
     */
    WebsiteNavArticle DT2P(WebsiteNavArticleDTO websiteNavArticleDTO);

    /**
     * P2B
     * @param websiteNavArticle
     * @return
     */
    WebsiteNavArticleBO P2B(WebsiteNavArticle websiteNavArticle);


    /**
     * P2B
     * @param websiteNavArticleList
     * @return
     */
    List<WebsiteNavArticleBO> P2B(List<WebsiteNavArticle> websiteNavArticleList);

    /**
     * B2V
     * @param websiteNavArticleBO
     * @return
     */
    WebsiteNavArticleVO B2V(WebsiteNavArticleBO websiteNavArticleBO);

    /**
     * B2V
     * @param websiteLinkBO
     * @return
     */
//    WebsiteLinkPageVO B2PV(WebsiteLinkBO websiteLinkBO);

    /**
     * B2V
     * @param websiteLinkBOList
     * @return
     */
//    List<WebsiteLinkPageVO> B2PV(List<WebsiteLinkBO> websiteLinkBOList);

    /**
     * B2V
     * @param result
     * @return
     */
//    PageResult<WebsiteLinkPageVO> B2PV(PageResult<WebsiteLinkBO> result);
}