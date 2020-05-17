package io.xxnjdg.notp.system.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 14:22
 */
@Data
@Accessors(chain = true)
public class DirectoryAndMenuVO implements Serializable {
    private static final long serialVersionUID = 94475472828197515L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单路径
     */
    private String path;
    /**
     * 接口URL
     */
    private String apiUrl;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单类型(1：目录 2：菜单 3：按钮)
     */
    private Integer menuType;
    /**
     * 是否显示
     */
    private boolean hidden;
    /**
     * 下级菜单集合
     */
    private List<DirectoryAndMenuVO> children;
}
