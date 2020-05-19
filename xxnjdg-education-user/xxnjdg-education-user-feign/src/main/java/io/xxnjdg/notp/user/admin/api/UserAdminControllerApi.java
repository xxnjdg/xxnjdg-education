package io.xxnjdg.notp.user.admin.api;

import io.xxnjdg.notp.user.admin.object.data.transfer.UserDTO;
import io.xxnjdg.notp.user.admin.object.view.UserVO;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 12:57
 */
@FeignClient(value = "xxnjdg-user-service",contextId = "UserAdminControllerApi")
public interface UserAdminControllerApi {

    /**
     * UserNo
     * @param userDTO
     * @return
     */
    @PostMapping("/feign/user/user/getByUserNo/")
    ResponseResult<UserVO> getUserByUserNo(@RequestBody @Validated UserDTO userDTO );

}
