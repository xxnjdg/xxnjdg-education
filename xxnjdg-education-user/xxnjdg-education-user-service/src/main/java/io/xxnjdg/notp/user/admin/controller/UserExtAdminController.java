package io.xxnjdg.notp.user.admin.controller;

import io.xxnjdg.notp.user.admin.object.business.UserExtBO;
import io.xxnjdg.notp.user.admin.object.convert.UserExtMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.UserExtDTO;
import io.xxnjdg.notp.user.admin.service.UserExtAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Get;
import io.xxnjdg.notp.utils.validator.group.Page;
import io.xxnjdg.notp.utils.validator.group.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 2:55
 */
@RestController
public class UserExtAdminController {
    @Autowired
    private UserExtAdminService userExtAdminService;


    @PostMapping("/user/pc/user/ext/list")
    public ResponseResult listUserExtByPage(@RequestBody @Validated(Page.class) UserExtDTO userExtDTO ){
        PageResult<UserExtBO> result = userExtAdminService.listUserExtByPage(userExtDTO);
        return ResponseResult.success(UserExtMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/user/pc/user/ext/update")
    public ResponseResult updateUserExt(@RequestBody @Validated(Update.class) UserExtDTO userExtDTO ){
        Boolean result = userExtAdminService.updateUserExt(userExtDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/user/pc/user/ext/view")
    public ResponseResult getUserExt(@RequestBody @Validated(Get.class) UserExtDTO userExtDTO ){
        UserExtBO result = userExtAdminService.getUserExt(userExtDTO);
        return ResponseResult.success(UserExtMapStruct.INSTANCE.B2VV(result));
    }
}
