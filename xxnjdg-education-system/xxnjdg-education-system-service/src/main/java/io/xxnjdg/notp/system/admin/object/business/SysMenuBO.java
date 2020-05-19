package io.xxnjdg.notp.system.admin.object.business;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 22:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenuBO implements Serializable {

    private static final long serialVersionUID=1L;

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
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 路由路径
     */
    private String menuUrl;

    /**
     * 接口URL
     */
    private String apiUrl;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 备注
     */
    private String remark;

    /**
     * 菜单类型(1：目录   2：菜单   3：按钮)
     */
    private Integer menuType;

    /**
     * 下级菜单集合
     */
    private List<SysMenuBO> children;
}