package io.xxnjdg.notp.system.admin.object.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 7:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenuRoleListVO {
    /**
     * 菜单角色关联表集合
     */
    private List<String> list;
}
