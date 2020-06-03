package io.xxnjdg.notp.user.admin.controller;

import io.xxnjdg.notp.user.admin.api.UserAdminControllerApi;
import io.xxnjdg.notp.user.admin.object.business.UserBO;
import io.xxnjdg.notp.user.admin.object.convert.UserMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.UserDTO;
import io.xxnjdg.notp.user.admin.object.view.UserVO;
import io.xxnjdg.notp.user.admin.service.UserAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 12:50
 */
@RestController("New-UserAdminController")
public class UserAdminController implements UserAdminControllerApi {
    @Autowired
    private UserAdminService userAdminService;

    @Override
    public ResponseResult<UserVO> getUserByUserNo(UserDTO userDTO) {
        UserBO result = userAdminService.getUserByUserNo(userDTO);
        return ResponseResult.success(UserMapStruct.INSTANCE.B2V(result));
    }

    @PostMapping("/user/pc/user/list")
    public ResponseResult listUserByPage(@RequestBody @Validated(Page.class) UserDTO userDTO ){
        PageResult<UserBO> result = userAdminService.listUserByPage(userDTO);
        return ResponseResult.success(UserMapStruct.INSTANCE.B2PV(result));
    }
}
