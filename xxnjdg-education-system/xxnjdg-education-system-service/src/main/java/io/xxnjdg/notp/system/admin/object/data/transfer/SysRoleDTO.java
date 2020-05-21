package io.xxnjdg.notp.system.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 15:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRoleDTO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {ListGroup.class})
    @NotBlank(message = ValidationMessage.PARAMETER_NULL, groups = {ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class, Get.class,Page.class,Update.class,Delete.class})
    private Long userId;

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
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class, Get.class,ListGroup.class,Delete.class})
    private Integer statusId;

    /**
     * 名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL, groups = {Insert.class})
    @Length(max = 49,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class,Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,ListGroup.class,Delete.class})
    private String roleName;

    /**
     * 备注
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL, groups = {Insert.class})
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class,ListGroup.class,Delete.class})
    private String remark;

    /**
     * 主键
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class,Get.class,Delete.class})
    @NotBlank(message = ValidationMessage.PARAMETER_NULL, groups = {Update.class,Get.class,Delete.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Insert.class,ListGroup.class})
    private Long id;

    /**
     * 排序
     */
    @Range(min = 1, max = Integer.MAX_VALUE, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Insert.class,Get.class,ListGroup.class,Delete.class})
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
