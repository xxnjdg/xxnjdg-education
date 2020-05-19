package io.xxnjdg.notp.system.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 22:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenuDTO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 菜单名称
     */
    @Length(max = 49,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {ListGroup.class,Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Delete.class, Get.class})
    private String menuName;

    /**
     * 父ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = { Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class,Delete.class, Get.class})
    private Long parentId;

    /**
     * 路由路径
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class,Delete.class, Get.class})
    private String menuUrl;

    /**
     * 接口URL
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class,Delete.class, Get.class})
    private String apiUrl;

    /**
     * 菜单图标
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class,Delete.class, Get.class})
    private String menuIcon;

    /**
     * 备注
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class,Delete.class, Get.class})
    private String remark;

    /**
     * 排序
     */
    @Range(min = 1, max = Integer.MAX_VALUE, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class,Delete.class, Get.class})
    private Integer sort;

    /**
     * 菜单类型(1：目录   2：菜单   3：按钮)
     */
    @Range(min = 1,max =3, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = { Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class,Delete.class, Get.class})
    private Integer menuType;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL, groups = {Delete.class,Update.class , Get.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {Delete.class,Update.class, Get.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class,Insert.class})
    private Long id;

    /**
     * 状态(1:正常，0:禁用)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class,Insert.class,Delete.class, Get.class})
    private Integer statusId;

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