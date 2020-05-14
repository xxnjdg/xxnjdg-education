package io.xxnjdg.notp.system.service;

import io.xxnjdg.notp.system.object.business.SysMenuRoleBO;
import io.xxnjdg.notp.system.object.data.transfer.SysMenuRoleDTO;
import io.xxnjdg.notp.system.object.persistent.SysMenuRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜单角色关联表 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface SysMenuRoleService extends IService<SysMenuRole> {

    /**
     * 查询SysMenuRole列表
     * @param sysMenuRoleDTO
     * @return
     */
    SysMenuRoleBO listSysMenuRole(SysMenuRoleDTO sysMenuRoleDTO);

}
