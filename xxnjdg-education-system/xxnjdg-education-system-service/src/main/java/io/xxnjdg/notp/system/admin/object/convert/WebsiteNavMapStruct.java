package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.WebsiteNavBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteNavDTO;
import io.xxnjdg.notp.system.admin.object.view.WebsiteNavPageVO;
import io.xxnjdg.notp.system.object.persistent.WebsiteNav;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 19:58
 */
@Mapper
public interface WebsiteNavMapStruct {
    WebsiteNavMapStruct INSTANCE = Mappers.getMapper(WebsiteNavMapStruct.class);

    /**
     * P2B
     * @param websiteNavDTO
     * @return
     */
    WebsiteNav DT2P(WebsiteNavDTO websiteNavDTO);

    /**
     * P2B
     * @param websiteNav
     * @return
     */
    WebsiteNavBO P2B(WebsiteNav websiteNav);


    /**
     * P2B
     * @param websiteNavList
     * @return
     */
    List<WebsiteNavBO> P2B(List<WebsiteNav> websiteNavList);

    /**
     * B2V
     * @param websiteLinkBO
     * @return
     */
//    WebsiteLinkVO B2V(WebsiteLinkBO websiteLinkBO);

    /**
     * B2V
     * @param websiteLinkBO
     * @return
     */
    WebsiteNavPageVO B2PV(WebsiteNavBO websiteLinkBO);

    /**
     * B2V
     * @param websiteLinkBOList
     * @return
     */
    List<WebsiteNavPageVO> B2PV(List<WebsiteNavBO> websiteLinkBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<WebsiteNavPageVO> B2PV(PageResult<WebsiteNavBO> result);
}