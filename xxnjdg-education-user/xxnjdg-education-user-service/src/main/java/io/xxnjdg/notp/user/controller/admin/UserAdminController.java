package io.xxnjdg.notp.user.controller.admin;

import io.xxnjdg.notp.user.object.data.transfer.UserLoginPasswordDTO;
import io.xxnjdg.notp.user.object.data.transfer.UserRegisterDTO;
import io.xxnjdg.notp.user.object.view.UserLoginVO;
import io.xxnjdg.notp.user.service.UserService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-14 下午5:54
 */
@RestController
public class UserAdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/pc/api/user/login/password")
    public ResponseResult userLogin(@RequestBody @Validated UserLoginPasswordDTO userLoginPasswordDTO){
        UserLoginVO userLoginVO = userService.postUserLoginByPassword(userLoginPasswordDTO.setAdmin(true));
        return ResponseResult.success(userLoginVO);
    }
}