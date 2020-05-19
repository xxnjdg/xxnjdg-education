package io.xxnjdg.notp.user.admin.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 13:30
 */
@Getter
@AllArgsConstructor
public enum UserEnum implements BaseResponse {

    /**
     * 错误请求
     */
    GET_ERROR(400,"用户查询异常，请联系管理员"),

    /**
     * 错误请求
     */
    UPDATE_ERROR(400,"用户更新异常，请联系管理员"),

    /**
     * 错误请求
     */
    DELETE_ERROR(400,"用户删除异常，请联系管理员"),
    /**
     * 错误请求
     */
    SAVE_ERROR(400,"用户插入异常，请联系管理员");

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