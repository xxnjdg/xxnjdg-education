package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.MsgUserBO;
import io.xxnjdg.notp.system.admin.object.convert.MsgUserMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgUserDTO;
import io.xxnjdg.notp.system.admin.service.MsgUserAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Delete;
import io.xxnjdg.notp.utils.validator.group.Get;
import io.xxnjdg.notp.utils.validator.group.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 13:49
 */
@RestController
public class MsgUserAdminController {

    @Autowired
    private MsgUserAdminService msgUserAdminService;

    @PostMapping("/system/pc/msg/user/list")
    public ResponseResult listMsgUserByPage(@RequestBody @Validated(Page.class) MsgUserDTO msgUserDTO ){
        PageResult<MsgUserBO> result = msgUserAdminService.listMsgUserByPage(msgUserDTO);
        return ResponseResult.success(MsgUserMapStruct.INSTANCE.B2V(result));
    }

    @PostMapping("/system/pc/msg/user/delete")
    public ResponseResult deleteMsgUser(@RequestBody @Validated(Delete.class) MsgUserDTO msgUserDTO ){
        Boolean result = msgUserAdminService.deleteMsgUserById(msgUserDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/msg/user/view")
    public ResponseResult getMsgUserById(@RequestBody @Validated(Get.class) MsgUserDTO msgUserDTO ){
        MsgUserBO msgUserBO = msgUserAdminService.getMsgUserById(msgUserDTO);
        return ResponseResult.success(MsgUserMapStruct.INSTANCE.B2FV(msgUserBO));
    }

}
