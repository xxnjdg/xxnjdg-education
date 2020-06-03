package io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.audit;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/30 19:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseChapterAuditDeleteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 章节编号
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long id;

    /**
     * 用户编号(不属于类的字段)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long userNo;
}