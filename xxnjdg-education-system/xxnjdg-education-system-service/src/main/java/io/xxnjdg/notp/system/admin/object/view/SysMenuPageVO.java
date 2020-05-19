package io.xxnjdg.notp.system.admin.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 6:49
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenuPageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;
    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单名称(Tree 树形控件规范)
     */
    private String label;
    /**
     * 菜单路径
     */
    private String menuUrl;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 接口URL
     */
    private String apiUrl;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否显示(1: 显示；0:不显示)
     */
    private Integer hiddenType;
    /**
     * 菜单类型(1：目录 2：菜单 3：按钮)
     */
    private Integer menuType;
    /**
     * 下级菜单集合
     */
    private List<SysMenuPageVO> children;
}
