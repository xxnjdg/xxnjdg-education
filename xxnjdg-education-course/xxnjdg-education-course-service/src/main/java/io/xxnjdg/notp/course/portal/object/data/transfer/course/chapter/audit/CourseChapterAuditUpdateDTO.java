package io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.audit;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/30 17:41
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseChapterAuditUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 章节编号
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long id;

    /**
     * 章节名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Size(max = 64,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String chapterName;

    /**
     * 是否免费：1免费，0收费
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Integer isFree;

    /**
     * 用户编号(不属于类的字段)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long userNo;
}