package io.xxnjdg.notp.course.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Get;
import io.xxnjdg.notp.utils.validator.group.Page;
import io.xxnjdg.notp.utils.validator.group.Update;
import io.xxnjdg.notp.utils.validator.group.View;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 16:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseDTO implements Serializable {

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
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, View.class})
    private Integer statusId;

    /**
     * 一级分类ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, View.class})
    private Long categoryId1;

    /**
     * 课程名称
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,View.class})
    private String courseName;

    /**
     * 是否免费：1免费，0收费
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,View.class})
    private Integer isFree;

    /**
     * 是否上架(1:上架，0:下架)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,View.class})
    private Integer isPutaway;

    /**
     * 专区编号 没有这个字段
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class,Get.class,View.class})
    private Long zoneId;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = { Update.class,Get.class,View.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Update.class,Get.class,View.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class})
    private Long id;


    @Pattern(regexp = "^\\+?(?!0+(\\d|(\\.00?)?$))\\d+(\\.\\d\\d?)?$",message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class})
    @Length(max = 10,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class,View.class})
    private String courseOriginal;

    /**
     * 优惠价
     */
    @Pattern(regexp = "^\\+?(?!0+(\\d|(\\.00?)?$))\\d+(\\.\\d\\d?)?$",message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class})
    @Length(max = 10,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class,View.class})
    private String courseDiscount;

    /**
     * 课程简介 没有这个字段
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class,View.class})
    private String introduce;

    /**
     * 排序
     */
    @Range(min=1,max= Integer.MAX_VALUE,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = { Page.class,Get.class,View.class})
    private Integer sort;

    /**
     * 二级分类ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class,View.class})
    private Long categoryId2;

    /**
     * 三级分类ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class,View.class})
    private Long categoryId3;

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
     * 课程封面
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String courseLogo;

    /**
     * 课程介绍ID
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long introduceId;

    /**
     * 课程排序(前端显示使用)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer courseSort;

    /**
     * 购买人数
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer countBuy;

    /**
     * 学习人数
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer countStudy;

    /**
     * 总课时数
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer periodTotal;

}
