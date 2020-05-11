package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-11 上午3:13
 */
@Data
@Accessors(chain = true)
public class CourseIntroduceAuditDTO implements Serializable {

    private static final long serialVersionUID = -2743319903379929603L;
    /**
     * 主键
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[\\d]{1,20}$")
    private String id;

    /**
     * 课程简介
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String introduce;

}