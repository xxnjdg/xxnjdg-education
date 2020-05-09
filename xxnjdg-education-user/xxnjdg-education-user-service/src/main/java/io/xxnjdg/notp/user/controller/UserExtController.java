package io.xxnjdg.notp.user.controller;


import io.xxnjdg.notp.user.object.business.UserExtBO;
import io.xxnjdg.notp.user.object.convert.UserExtMapper;
import io.xxnjdg.notp.user.object.data.transfer.UpdateUserExtDTO;
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
    public ResponseResult getUserExtByUserNo(@RequestHeader("userNo") @Pattern(regexp = "^[\\d]{1,20}$",message = "参数错误") String userNo ) {
        UserExtBO userExtBO = userExtService.getUserExtByUserNo(userNo);
        UserExtVO userExtVO = UserExtMapper.INSTANCE.convertB2V(userExtBO);
        return ResponseResult.success(userExtVO);
    }

    @PostMapping("/user/auth/user/ext/update")
    public ResponseResult updateUserExt(@RequestBody @Validated UpdateUserExtDTO updateUserExtDTO) {
        UserExtBO userExtBO = userExtService.updateUserExt(updateUserExtDTO);
        UserExtVO userExtVO = UserExtMapper.INSTANCE.convertB2V(userExtBO);
        return ResponseResult.success(userExtVO);
    }
}

