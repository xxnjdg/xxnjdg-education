package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.WebsiteLinkBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteLinkDTO;
import io.xxnjdg.notp.system.admin.object.view.WebsiteLinkPageVO;
import io.xxnjdg.notp.system.admin.object.view.WebsiteLinkVO;
import io.xxnjdg.notp.system.object.persistent.WebsiteLink;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 18:04
 */
@Mapper
public interface WebsiteLinkMapStruct {
    WebsiteLinkMapStruct INSTANCE = Mappers.getMapper(WebsiteLinkMapStruct.class);

    /**
     * P2B
     * @param websiteLinkDTO
     * @return
     */
    WebsiteLink DTP2P(WebsiteLinkDTO websiteLinkDTO);

    /**
     * P2B
     * @param websiteLink
     * @return
     */
    WebsiteLinkBO P2B(WebsiteLink websiteLink);


    /**
     * P2B
     * @param websiteLinkList
     * @return
     */
    List<WebsiteLinkBO> P2B(List<WebsiteLink> websiteLinkList);

    /**
     * B2V
     * @param websiteLinkBO
     * @return
     */
    WebsiteLinkVO B2V(WebsiteLinkBO websiteLinkBO);

    /**
     * B2V
     * @param websiteLinkBO
     * @return
     */
    WebsiteLinkPageVO B2PV(WebsiteLinkBO websiteLinkBO);

    /**
     * B2V
     * @param websiteLinkBOList
     * @return
     */
    List<WebsiteLinkPageVO> B2PV(List<WebsiteLinkBO> websiteLinkBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<WebsiteLinkPageVO> B2PV(PageResult<WebsiteLinkBO> result);
}
