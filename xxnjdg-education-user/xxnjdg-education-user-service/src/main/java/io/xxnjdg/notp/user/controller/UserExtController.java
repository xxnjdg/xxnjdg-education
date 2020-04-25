package io.xxnjdg.notp.user.controller;


import io.xxnjdg.notp.user.object.data.transfer.UserExtDTO;
import io.xxnjdg.notp.user.object.view.UserExtVO;
import io.xxnjdg.notp.user.service.UserExtService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;


/**
 * <p>
 * 用户教育信息 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@RestController
@Validated
public class UserExtController {

    @Autowired
    private UserExtService userExtService;

    @PostMapping("/user/auth/user/ext/view")
    public ResponseResult postUserExt(@RequestHeader("userNo") @Pattern(regexp = "^[\\d]{1,20}$",message = "参数错误") String userNo ) {
        UserExtVO userExtVO = userExtService.postUserExt(userNo);
        return ResponseResult.success(userExtVO);
    }

}

