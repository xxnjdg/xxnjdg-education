package io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/31 2:37
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseChapterPeriodAuditSaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 章节ID
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long chapterId;

    /**
     * 课时描述
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private String periodDesc;

    /**
     * 是否免费：1免费，0收费
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Integer isFree;

    /**
     * 排序
     */
    @Range(min = 1,max= Integer.MAX_VALUE,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Integer sort;

    /**
     * 文档名称
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private String docName;

    /**
     * 文档地址
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private String docUrl;

    /**
     * 课时名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Length(max = 254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private String periodName;

    /**
     * 用户编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long userNo;

}
