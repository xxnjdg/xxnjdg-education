package io.xxnjdg.notp.user.admin.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 17:59
 */
@Getter
@AllArgsConstructor
public enum LecturerProfitEnum implements BaseResponse {

    /**
     * 错误请求
     */
    GET_ERROR(400,"教师查询异常，请联系管理员"),

    /**
     * 错误请求
     */
    UPDATE_ERROR(400,"教师更新异常，请联系管理员"),

    /**
     * 错误请求
     */
    DELETE_ERROR(400,"教师删除异常，请联系管理员"),
    /**
     * 错误请求
     */
    SAVE_ERROR(400,"教师插入异常，请联系管理员");

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
