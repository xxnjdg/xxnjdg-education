package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.SysRoleUserBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.object.persistent.SysRoleUser;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 15:00
 */
public interface SysRoleUserAdminService extends IService<SysRoleUser> {
    /**
     * 查询SysRoleUser列表
     * @param sysRoleUserDTO
     * @return
     */
    List<SysRoleUserBO> listSysRoleUserByUserId(SysRoleUserDTO sysRoleUserDTO);

    /**
     * 插入SysRoleUser
     * @param sysRoleUserDTO
     * @return
     */
    Boolean saveSysRoleUser(SysRoleUserDTO sysRoleUserDTO);

    /**
     * 删除SysRoleUser
     * @param sysRoleUserDTO
     * @return
     */
    Boolean deleteSysRoleUserByUserId(SysRoleUserDTO sysRoleUserDTO);
}
