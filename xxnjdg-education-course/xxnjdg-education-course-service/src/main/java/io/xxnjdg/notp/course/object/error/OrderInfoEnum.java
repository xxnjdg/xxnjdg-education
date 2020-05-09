package io.xxnjdg.notp.course.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-27 下午5:42
 */
@Getter
@AllArgsConstructor
public enum  OrderInfoEnum implements BaseResponse {
    /**
     * 错误请求
     */
    USER_NO_ERROR(400,"用户状态异常，请联系管理员");

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