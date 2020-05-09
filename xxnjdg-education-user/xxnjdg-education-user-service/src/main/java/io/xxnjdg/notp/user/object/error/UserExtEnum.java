package io.xxnjdg.notp.user.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-24 下午5:50
 */
@AllArgsConstructor
@Getter
public enum UserExtEnum implements BaseResponse {
    /**
     * 错误请求
     */
    USER_EXT_ERROR(400, "用户信息获取失败"),

    /**
     * 用户信息更新失败
     */
    USER_EXT_UPDATE_ERROR(400, "用户信息更新失败");

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
