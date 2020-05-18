package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.MsgTemplateBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgTemplateDTO;
import io.xxnjdg.notp.system.object.persistent.MsgTemplate;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 16:08
 */
public interface MsgTemplateAdminService extends IService<MsgTemplate> {
    /**
     * 分页查询MsgTemplate列表
     * @param msgTemplateDTO
     * @return
     */
    PageResult<MsgTemplateBO> listMsgTemplateByPage(MsgTemplateDTO msgTemplateDTO);

    /**
     * 删除MsgTemplate
     * @param msgTemplateDTO
     * @return
     */
    Boolean deleteMsgTemplateById(MsgTemplateDTO msgTemplateDTO);

    /**
     * 插入MsgTemplate
     * @param msgTemplateDTO
     * @return
     */
    Boolean saveMsgTemplate(MsgTemplateDTO msgTemplateDTO);

    /**
     * 更新MsgTemplate
     * @param msgTemplateDTO
     * @return
     */
    Boolean updateMsgTemplateById(MsgTemplateDTO msgTemplateDTO);

    /**
     * 查询MsgTemplate
     * @param msgTemplateDTO
     * @return
     */
    MsgTemplateBO getMsgTemplateById(MsgTemplateDTO msgTemplateDTO);
}
