package io.xxnjdg.notp.user.controller;


import io.xxnjdg.notp.user.object.data.transfer.UserLoginPasswordDTO;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户基本信息 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@RestController
public class UserController {


    @PostMapping("/user/api/user/login/password")
    public ResponseResult postUserLoginByPassword(@RequestBody @Validated UserLoginPasswordDTO userLoginPasswordDTO){
        return ResponseResult.success();
    }


}

