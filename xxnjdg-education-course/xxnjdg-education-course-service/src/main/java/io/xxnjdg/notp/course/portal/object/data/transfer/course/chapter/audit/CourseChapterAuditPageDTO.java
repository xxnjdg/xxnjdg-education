package io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.audit;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 23:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseChapterAuditPageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 课程ID
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long courseId;
}
