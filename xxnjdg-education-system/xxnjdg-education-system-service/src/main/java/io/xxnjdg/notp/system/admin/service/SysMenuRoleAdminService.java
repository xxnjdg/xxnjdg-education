package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.SysMenuRoleBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysMenuRoleDTO;
import io.xxnjdg.notp.system.object.persistent.SysMenuRole;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 7:04
 */
public interface SysMenuRoleAdminService extends IService<SysMenuRole> {

    /**
     * 查询SysMenuRole列表
     * @param sysMenuRoleDTO
     * @return
     */
    SysMenuRoleBO listSysMenuRole(SysMenuRoleDTO sysMenuRoleDTO);

    /**
     * 插入
     * @param sysMenuRoleDTO
     * @return
     */
    Boolean saveSysMenuRole(SysMenuRoleDTO sysMenuRoleDTO);

    /**
     * 删除
     * @param sysMenuRoleDTO
     * @return
     */
    Boolean deleteSysMenuRoleByRoleId(SysMenuRoleDTO sysMenuRoleDTO);
}
