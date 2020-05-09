package io.xxnjdg.notp.gateway.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-27 下午1:38
 */
@AllArgsConstructor
@Getter
public enum ErrorStatus implements BaseResponse {

    /**
     * 会话过期,请重新登陆
     */
    TOKEN_NULL(301,"会话过期,请重新登陆");


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