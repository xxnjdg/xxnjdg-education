package io.xxnjdg.notp.utils.constant;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午3:03
 */
@AllArgsConstructor
@Getter
public enum HttpStatus implements BaseResponse {

    /**
     * 操作成功
     */
    SUCCESS(200,"操作成功"),
    /**
     * 资源，服务未找到
     */
    NOT_FOUND(404,"服务未找到"),
    /**
     * 系统内部错误
     */
    ERROR(500,"系统内部错误");

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
