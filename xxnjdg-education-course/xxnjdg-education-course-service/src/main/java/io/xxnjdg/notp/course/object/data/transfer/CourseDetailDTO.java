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
 * @date 20-4-28 下午12:54
 */
@Data
@Accessors(chain = true)
public class CourseDetailDTO implements Serializable {
    private static final long serialVersionUID = 5072044038328476996L;

    /**
     * 课程ID
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[\\d]{1,20}$")
    private String courseId;

    /**
     * 用户id
     */
    private Long userNo;
}
