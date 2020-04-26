package io.xxnjdg.notp.user.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-26 下午1:30
 */
@Getter
@AllArgsConstructor
public enum  SendSmsLogEnum implements BaseResponse {
    /**
     * 错误请求
     */
    SEND_SMS_ERROR(400,"发送状态异常，请联系管理员");

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