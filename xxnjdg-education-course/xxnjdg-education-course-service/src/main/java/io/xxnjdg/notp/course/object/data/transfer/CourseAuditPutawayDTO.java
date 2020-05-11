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
 * @date 20-5-11 下午3:13
 */
@Data
@Accessors(chain = true)
public class CourseAuditPutawayDTO implements Serializable {
    private static final long serialVersionUID = -8976717871844917624L;
    /**
     * 课程ID
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[\\d]{1,20}$")
    private String id;
    /**
     * 是否上架(1:上架，0:下架)
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[0-1]$",message = ValidationMessage.PARAMETER_ERROR)
    private String isPutaway;
    /**
     * 用户编号
     */
    private Long lecturerUserNo;
}
