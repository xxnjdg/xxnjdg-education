package io.xxnjdg.notp.system.admin.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 22:12
 */
@Getter
@AllArgsConstructor
public enum SysMenuEnum implements BaseResponse {

    /**
     * 错误请求
     */
    GET_ERROR(400,"菜单查询异常，请联系管理员"),

    /**
     * 错误请求
     */
    UPDATE_ERROR(400,"菜单更新异常，请联系管理员"),

    /**
     * 错误请求
     */
    DELETE_ERROR(400,"菜单删除异常，请联系管理员"),
    /**
     * 错误请求
     */
    SAVE_ERROR(400,"菜单插入异常，请联系管理员");

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