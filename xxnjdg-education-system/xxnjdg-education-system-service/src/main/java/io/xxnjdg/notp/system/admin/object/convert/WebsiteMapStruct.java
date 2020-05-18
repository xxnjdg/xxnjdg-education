package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.WebsiteBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteDTO;
import io.xxnjdg.notp.system.admin.object.view.WebsiteListVO;
import io.xxnjdg.notp.system.object.persistent.Website;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 19:05
 */
@Mapper
public interface WebsiteMapStruct {
    WebsiteMapStruct INSTANCE = Mappers.getMapper(WebsiteMapStruct.class);

    /**
     *
     * @param websiteDTO
     * @return
     */
    Website DTO2P(WebsiteDTO websiteDTO);

    /**
     * P2B
     * @param website
     * @return
     */
    WebsiteBO P2B(Website website);


    /**
     * P2B
     * @param websiteList
     * @return
     */
    List<WebsiteBO> P2B(List<Website> websiteList);

    /**
     * B2V
     * @param websiteBO
     * @return
     */
    WebsiteListVO B2V(WebsiteBO websiteBO);

    /**
     * B2V
     * @param websiteBOList
     * @return
     */
    List<WebsiteListVO> B2V(List<WebsiteBO> websiteBOList);


}