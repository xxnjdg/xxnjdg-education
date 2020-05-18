package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.MsgBO;
import io.xxnjdg.notp.system.admin.object.convert.MsgMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgDTO;
import io.xxnjdg.notp.system.admin.service.MsgAdminService;
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
 * @date 2020/5/18 2:18
 */
@RestController
public class MsgAdminController {

    @Autowired
    private MsgAdminService msgAdminService;

    @PostMapping("/system/pc/msg/list")
    public ResponseResult listMsgByPage(@RequestBody @Validated(Page.class) MsgDTO msgDTO ){
        PageResult<MsgBO> result = msgAdminService.listMsgByPage(msgDTO);
        return ResponseResult.success(MsgMapStruct.INSTANCE.B2V(result));
    }

    @PostMapping("/system/pc/msg/save")
    public ResponseResult saveMsg(@RequestBody @Validated(Insert.class) MsgDTO msgDTO ){
        Boolean result = msgAdminService.saveMsg(msgDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/msg/delete")
    public ResponseResult deleteMsg(@RequestBody @Validated(Delete.class) MsgDTO msgDTO ){
        Boolean result = msgAdminService.deleteMsg(msgDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/msg/update")
    public ResponseResult updateMsg(@RequestBody @Validated(Update.class) MsgDTO msgDTO ){
        Boolean result = msgAdminService.updateMsg(msgDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/msg/view")
    public ResponseResult getMsg(@RequestBody @Validated(Get.class) MsgDTO msgDTO ){
        MsgBO msgBO = msgAdminService.getMsg(msgDTO);
        return ResponseResult.success(MsgMapStruct.INSTANCE.B2FV(msgBO));
    }

}
