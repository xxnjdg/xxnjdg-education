package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.MsgTemplateBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgTemplateDTO;
import io.xxnjdg.notp.system.admin.object.view.MsgTemplatePageVO;
import io.xxnjdg.notp.system.admin.object.view.MsgTemplateVO;
import io.xxnjdg.notp.system.object.persistent.MsgTemplate;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 16:25
 */
@Mapper
public interface MsgTemplateMapStruct {
    MsgTemplateMapStruct INSTANCE = Mappers.getMapper(MsgTemplateMapStruct.class);

    /**
     * P2B
     * @param msgTemplateDTO
     * @return
     */
    MsgTemplate DTO2P(MsgTemplateDTO msgTemplateDTO);

    /**
     * P2B
     * @param msgTemplate
     * @return
     */
    MsgTemplateBO P2B(MsgTemplate msgTemplate);


    /**
     * P2B
     * @param msgTemplateList
     * @return
     */
    List<MsgTemplateBO> P2B(List<MsgTemplate> msgTemplateList);

    /**
     * B2V
     * @param msgTemplateBO
     * @return
     */
    MsgTemplatePageVO B2PV(MsgTemplateBO msgTemplateBO);

    /**
     * B2V
     * @param msgTemplateBOList
     * @return
     */
    List<MsgTemplatePageVO> B2PV(List<MsgTemplateBO> msgTemplateBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<MsgTemplatePageVO> B2PV(PageResult<MsgTemplateBO> result);

    /**
     * B2V
     * @param msgTemplateBO
     * @return
     */
    MsgTemplateVO B2V(MsgTemplateBO msgTemplateBO);

}