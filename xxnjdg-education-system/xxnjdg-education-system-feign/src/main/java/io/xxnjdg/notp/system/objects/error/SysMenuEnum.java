package io.xxnjdg.notp.system.objects.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/16 20:22
 */
@Getter
@AllArgsConstructor
public enum SysMenuEnum implements BaseResponse {
    /**
     * 错误请求
     */
    GET_ERROR(400,"系统查询异常，请联系管理员");

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