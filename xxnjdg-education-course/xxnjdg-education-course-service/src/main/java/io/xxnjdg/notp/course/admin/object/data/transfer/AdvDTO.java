package io.xxnjdg.notp.course.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 13:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdvDTO implements Serializable {

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
     * 位置(0电脑端，1微信端)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class, Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, Update.class, Delete.class})
    private Integer platShow;

    /**
     * 广告标题
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = { Insert.class})
    @Length(max = 254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class, Insert.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, Delete.class})
    private String advTitle;

    /**
     * 状态(1:正常，0:禁用)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class,Get.class, Delete.class})
    private Integer statusId;

    /**
     * 广告图片
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class, Delete.class})
    private String advImg;

    /**
     * 广告链接
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = { Insert.class})
    @Length(max = 254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class, Delete.class})
    private String advUrl;

    /**
     * 广告跳转方式
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class, Delete.class})
    private String advTarget;

    /**
     * 开始时间
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class, Delete.class})
    private LocalDateTime beginTime;

    /**
     * 结束时间
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class, Delete.class})
    private LocalDateTime endTime;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = { Get.class, Update.class, Delete.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Get.class, Update.class, Delete.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Insert.class})
    private Long id;

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
     * 排序
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer sort;

    /**
     * 广告位置(1首页轮播)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer advLocation;
}
