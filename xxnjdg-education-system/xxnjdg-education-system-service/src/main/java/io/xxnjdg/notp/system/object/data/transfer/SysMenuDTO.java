package io.xxnjdg.notp.system.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/15 20:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenuDTO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long userNo;

    /**
     * 主键列表
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Collection<Long> ids;

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
     * 父ID
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long parentId;

    /**
     * 菜单名称
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String menuName;

    /**
     * 路由路径
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String menuUrl;

    /**
     * 接口URL
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String apiUrl;

    /**
     * 菜单图标
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String menuIcon;

    /**
     * 备注
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String remark;

    /**
     * 菜单类型(1：目录   2：菜单   3：按钮)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer menuType;


}