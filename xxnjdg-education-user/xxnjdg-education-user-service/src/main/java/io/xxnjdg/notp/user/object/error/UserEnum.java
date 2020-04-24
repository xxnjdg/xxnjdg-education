package io.xxnjdg.notp.user.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-23 下午10:19
 */
@AllArgsConstructor
@Getter
public enum  UserEnum implements BaseResponse {
    /**
     * 错误请求
     */
    USER_OR_PASSWORD_ERROR(400,"用户名或密码错误");

    private Integer status;
    private String statusText;

    @Override
    public Integer status() {
        return status;
    }

    @Override
    public String statusText() {
        return statusText;
    }
}
