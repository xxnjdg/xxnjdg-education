package io.xxnjdg.notp.course.portal.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/31 3:24
 */
@Getter
@AllArgsConstructor
public enum CourseChapterPeriodAuditEnum implements BaseResponse {

    /**
     * 错误请求
     */
    GET_ERROR(400,"课程章节课时查询异常，请联系管理员"),

    /**
     * 错误请求
     */
    UPDATE_ERROR(400,"课程章节课时更新异常，请联系管理员"),

    /**
     * 错误请求
     */
    LOCK_ERROR(400,"加锁失败，请联系管理员"),
    /**
     * 错误请求
     */
    DELETE_ERROR(400,"课程章节课时删除异常，请联系管理员"),
    /**
     * 错误请求
     */
    SAVE_ERROR(400,"课程章节课时插入异常，请联系管理员");

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