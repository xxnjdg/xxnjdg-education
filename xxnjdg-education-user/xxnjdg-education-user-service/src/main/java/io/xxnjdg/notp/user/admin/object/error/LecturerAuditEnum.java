package io.xxnjdg.notp.user.admin.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/24 16:04
 */
@Getter
@AllArgsConstructor
public enum LecturerAuditEnum implements BaseResponse {

    /**
     * 错误请求
     */
    GET_ERROR(400,"教师审核查询异常，请联系管理员"),

    /**
     * 错误请求
     */
    UPDATE_ERROR(400,"教师审核更新异常，请联系管理员"),

    /**
     * 错误请求
     */
    DELETE_ERROR(400,"教师审核删除异常，请联系管理员"),
    /**
     * 错误请求
     */
    SAVE_ERROR(400,"教师审核插入异常，请联系管理员");

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