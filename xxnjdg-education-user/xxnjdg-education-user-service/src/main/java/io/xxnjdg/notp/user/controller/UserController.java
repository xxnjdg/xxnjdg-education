package io.xxnjdg.notp.user.controller;


import io.xxnjdg.notp.user.object.data.transfer.UserLoginPasswordDTO;
import io.xxnjdg.notp.user.object.data.transfer.UserRegisterDTO;
import io.xxnjdg.notp.user.object.view.UserLoginVO;
import io.xxnjdg.notp.user.service.UserService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @PostMapping("/user/api/user/login/password")
    public ResponseResult<UserLoginVO> postUserLoginByPassword(@RequestBody @Validated UserLoginPasswordDTO userLoginPasswordDTO){
        UserLoginVO userLoginVO = userService.postUserLoginByPassword(userLoginPasswordDTO);
        return ResponseResult.success(userLoginVO);
    }

    @PostMapping("/user/api/user/register")
    public ResponseResult<UserLoginVO> postUserRegister(@RequestBody @Validated UserRegisterDTO userRegisterDTO){
        UserLoginVO userLoginVO = userService.postUserRegister(userRegisterDTO);
        return ResponseResult.success(userLoginVO);
    }


}

