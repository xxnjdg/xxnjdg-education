package io.xxnjdg.notp.course.object.error;

import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午5:23
 */
@Getter
@AllArgsConstructor
public enum CourseIntroduceEnum implements BaseResponse {
    /**
     * 错误请求
     */
    COURSE_INTRODUCE_NOT_FOUND_ERROR(400, "课程描述异常，请联系管理员");

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