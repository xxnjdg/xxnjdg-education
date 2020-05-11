package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.Update;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class})
    @Pattern(regexp = "^[\\d]{1,20}$",message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    private String id;

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
     * 排序
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Pattern(regexp = "^[1-254]$",message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    private String sort;

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
     * 课程ID
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Pattern(regexp = "^[\\d]{1,20}$",message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    private String courseId;

    /**
     * 章节名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Size(max = 64,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String chapterName;

    /**
     * 章节描述
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String chapterDesc;

    /**
     * 是否免费：1免费，0收费
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[0-1]$",message = ValidationMessage.PARAMETER_ERROR)
    private String isFree;

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

    /**
     * 用户编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long userNo;
}
