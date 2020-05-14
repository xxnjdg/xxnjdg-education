package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.Update;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-12 上午2:41
 */
@Data
@Accessors(chain = true)
public class CourseChapterAuditDTO implements Serializable {
    private static final long serialVersionUID = -8514979407771076670L;
    /**
     * 主键
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class})
    private Long id;

    /**
     * 排序
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Range(min = 1,max= Integer.MAX_VALUE,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class})
    private Integer sort;

    /**
     * 课程ID
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class})
    private Long courseId;

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

    /**
     * 创建时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime gmtModified;

    /**
     * 状态(1:正常，0:禁用)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer statusId;

    /**
     * 审核状态(0:待审核;1:审核通过;2:审核不通过)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer auditStatus;

    /**
     * 审核意见
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String auditOpinion;

    /**
     * 章节描述
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String chapterDesc;

    /**
     * 原价
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal chapterOriginal;

    /**
     * 优惠价
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal chapterDiscount;

}
