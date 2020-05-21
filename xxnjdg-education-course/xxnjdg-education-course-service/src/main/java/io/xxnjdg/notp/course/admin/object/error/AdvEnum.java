package io.xxnjdg.notp.course.admin.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 13:55
 */
@Getter
@AllArgsConstructor
public enum AdvEnum implements BaseResponse {

    /**
     * 错误请求
     */
    GET_ERROR(400,"广告查询异常，请联系管理员"),

    /**
     * 错误请求
     */
    UPDATE_ERROR(400,"广告更新异常，请联系管理员"),

    /**
     * 错误请求
     */
    DELETE_ERROR(400,"广告删除异常，请联系管理员"),
    /**
     * 错误请求
     */
    SAVE_ERROR(400,"广告插入异常，请联系管理员");

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