package io.xxnjdg.notp.system.objects.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-26 上午12:14
 */
@Getter
@AllArgsConstructor
public enum SysEnum implements BaseResponse {
    /**
     * 错误请求
     */
    SYS_ERROR(400,"系统异常，请联系管理员");

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
