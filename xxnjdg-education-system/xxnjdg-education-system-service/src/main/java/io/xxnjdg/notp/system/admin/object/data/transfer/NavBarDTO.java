package io.xxnjdg.notp.system.admin.object.data.transfer;

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
 * @date 2020/5/20 16:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class NavBarDTO implements Serializable {

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
     * 导航标题
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class,Insert.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Delete.class, Get.class})
    private String navTitle;

    /**
     * 状态(1有效, 0无效)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class,Delete.class, Get.class})
    private Integer statusId;

    /**
     * 跳转方式
     */
    @NotBlank(message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class})
    @Length(max = 254,message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Delete.class, Get.class})
    private String target;

    /**
     * 导航url
     */
    @NotBlank(message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class})
    @Length(max = 254,message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Update.class,Delete.class, Get.class})
    private String navUrl;

    /**
     * 排序
     */
    @Range(min = 1, max = Integer.MAX_VALUE, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Insert.class,Delete.class, Get.class})
    private Integer sort;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL, groups = {Update.class,Delete.class, Get.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {Update.class,Delete.class, Get.class})
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


}