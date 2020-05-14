package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class, UpdatePutaway.class,View.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class, UpdatePutaway.class,View.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    private Long id;

    /**
     * 一级分类ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {UpdatePutaway.class,View.class})
    private Long categoryId1;

    /**
     * 二级分类ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {UpdatePutaway.class,View.class})
    private Long categoryId2;

    /**
     * 三级分类ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {UpdatePutaway.class,View.class})
    private Long categoryId3;

    /**
     * 课程名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class,Insert.class})
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Update.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {UpdatePutaway.class,View.class})
    private String courseName;

    /**
     * 课程封面
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class,Insert.class})
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Update.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {UpdatePutaway.class,View.class})
    private String courseLogo;

    /**
     * 原价
     */
    @Pattern(regexp = "^\\+?(?!0+(\\d|(\\.00?)?$))\\d+(\\.\\d\\d?)?$",message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class,Insert.class})
    @Length(max = 10,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Update.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {UpdatePutaway.class,View.class})
    private String courseOriginal;

    /**
     * 是否免费：1免费，0收费
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class,Insert.class})
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {UpdatePutaway.class,View.class})
    private Integer isFree;

    /**
     * 是否上架(1:上架，0:下架)
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {UpdatePutaway.class})
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {UpdatePutaway.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class,Insert.class,View.class})
    private Integer isPutaway;

    /**
     * 课程简介 没有这个字段
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {UpdatePutaway.class,View.class})
    private String introduce;

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
     * 讲师用户编码
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long lecturerUserNo;

    /**
     * 状态(1:正常，0:禁用)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer statusId;

    /**
     * 排序
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer sort;

    /**
     * 审核状态(0:待审核,1:审核通过,2:审核不通过)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer auditStatus;

    /**
     * 审核意见
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String auditOpinion;

    /**
     * 课程介绍ID
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long introduceId;

    /**
     * 优惠价
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal courseDiscount;



}
