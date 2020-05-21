package io.xxnjdg.notp.system.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.ListGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 7:08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenuRoleDTO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
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
     * 菜单ID
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long menuId;

    /**
     * 角色ID
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL, groups = {ListGroup.class, Insert.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {ListGroup.class, Insert.class})
    private Long roleId;

    /**
     * 菜单ID集合
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL, groups = {Insert.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class})
    private List<Long> menuIds;
}