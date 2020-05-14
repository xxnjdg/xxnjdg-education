package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long id;

    /**
     * 课程简介
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String introduce;

}