package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.MsgTemplateBO;
import io.xxnjdg.notp.system.admin.object.convert.MsgTemplateMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgTemplateDTO;
import io.xxnjdg.notp.system.admin.service.MsgTemplateAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 16:03
 */
@RestController
public class MsgTemplateAdminController {

    @Autowired
    private MsgTemplateAdminService msgTemplateAdminService;

    @PostMapping("/system/pc/msg/template/list")
    public ResponseResult listMsgTemplateByPage(@RequestBody @Validated(Page.class) MsgTemplateDTO msgTemplateDTO ){
        PageResult<MsgTemplateBO> result = msgTemplateAdminService.listMsgTemplateByPage(msgTemplateDTO);
        return ResponseResult.success(MsgTemplateMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/system/pc/msg/template/delete")
    public ResponseResult deleteMsgTemplateById(@RequestBody @Validated(Delete.class) MsgTemplateDTO msgTemplateDTO ){
        Boolean result = msgTemplateAdminService.deleteMsgTemplateById(msgTemplateDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/msg/template/save")
    public ResponseResult saveMsgTemplate(@RequestBody @Validated(Insert.class) MsgTemplateDTO msgTemplateDTO ){
        Boolean result = msgTemplateAdminService.saveMsgTemplate(msgTemplateDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/msg/template/update")
    public ResponseResult updateMsgTemplate(@RequestBody @Validated(Update.class) MsgTemplateDTO msgTemplateDTO ){
        Boolean result = msgTemplateAdminService.updateMsgTemplateById(msgTemplateDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/msg/template/view")
    public ResponseResult getMsgTemplate(@RequestBody @Validated(Get.class) MsgTemplateDTO msgTemplateDTO ){
        MsgTemplateBO result = msgTemplateAdminService.getMsgTemplateById(msgTemplateDTO);
        return ResponseResult.success(MsgTemplateMapStruct.INSTANCE.B2V(result));
    }

}
