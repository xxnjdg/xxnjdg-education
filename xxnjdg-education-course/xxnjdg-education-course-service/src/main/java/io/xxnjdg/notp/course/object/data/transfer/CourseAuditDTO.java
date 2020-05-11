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
 * @date 20-5-10 下午8:37
 */
@Data
@Accessors(chain = true)
public class CourseAuditDTO implements Serializable {
    private static final long serialVersionUID = 5749303223632968328L;

    /**
     * 主键
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[\\d]{1,20}$")
    private String id;

    /**
     * 审核状态(0:待审核,1:审核通过,2:审核不通过)
     */
    private Integer auditStatus;

}
