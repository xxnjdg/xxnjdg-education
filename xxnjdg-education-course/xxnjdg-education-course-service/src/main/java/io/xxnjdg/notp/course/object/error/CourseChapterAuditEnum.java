package io.xxnjdg.notp.course.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-10 下午8:51
 */
@Getter
@AllArgsConstructor
public enum CourseChapterAuditEnum implements BaseResponse {

    /**
     * 课程查询章节异常，请联系管理员
     */
    GET_ERROR(400, "课程查询章节异常，请联系管理员"),

    /**
     * 课程查询章节异常，请联系管理员
     */
    UPDATE_ERROR(400, "课程更新章节异常，请联系管理员"),

    /**
     * 课程章节异常，请联系管理员
     */
    INSERT_ERROR(400, "课程章节异常，请联系管理员");

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