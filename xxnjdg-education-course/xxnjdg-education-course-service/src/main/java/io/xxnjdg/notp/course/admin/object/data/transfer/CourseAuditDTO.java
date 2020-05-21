package io.xxnjdg.notp.course.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 23:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseAuditDTO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 当前页
     */
    @Pattern(regexp = "^[1-9]\\d*$",message = ValidationMessage.PARAMETER_ERROR)
    private String pageCurrent;

    /**
     * 每页记录数
     */
    @Pattern(regexp = "(^[1][0-9]$)|(^[2][0]$)|(^[1-9]$)",message = ValidationMessage.PARAMETER_ERROR)
    private String pageSize;

    /**
     * 状态(1:正常，0:禁用)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class})
    private Integer statusId;

    /**
     * 课程名称
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class})
    private String courseName;

    /**
     * 是否上架(1:上架，0:下架)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class})
    private Integer isPutaway;

    /**
     * 是否免费：1免费，0收费
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class})
    private Integer isFree;

    /**
     * 审核状态(0:待审核,1:审核通过,2:审核不通过)
     */
    @Range(max = 2,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class})
    private Integer auditStatus;

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 审核意见
     */
    private String auditOpinion;

    /**
     * 讲师用户编码
     */
    private Long lecturerUserNo;

    /**
     * 一级分类ID
     */
    private Long categoryId1;

    /**
     * 二级分类ID
     */
    private Long categoryId2;

    /**
     * 三级分类ID
     */
    private Long categoryId3;

    /**
     * 课程封面
     */
    private String courseLogo;

    /**
     * 课程介绍ID
     */
    private Long introduceId;

    /**
     * 原价
     */
    private BigDecimal courseOriginal;

    /**
     * 优惠价
     */
    private BigDecimal courseDiscount;

}
