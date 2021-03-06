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
 * @date 2020/5/21 17:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseCategoryDTO implements Serializable {

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
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, Delete.class,Insert.class, Update.class})
    private Integer statusId;

    /**
     * 父分类ID
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Page.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, Delete.class,Update.class})
    private Long parentId;

    /**
     * 分类类型(1课程，2资源)
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Range(min=1,max = 2,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, Delete.class,Update.class})
    private Integer categoryType;

    /**
     * 分类名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class,Update.class})
    @Length(max = 49,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class,Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, Delete.class})
    private String categoryName;

    /**
     * 层级
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Range(min = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class, Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class, Delete.class,Update.class})
    private Integer floor;

    /**
     * 备注
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class, Delete.class})
    private String remark;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class,Get.class, Delete.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class,Get.class, Delete.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class,Page.class})
    private Long id;

    /**
     * 排序
     */
    @Range(min = 1,max=Integer.MAX_VALUE, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class,Page.class,Get.class, Delete.class})
    private Integer sort;

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

}
