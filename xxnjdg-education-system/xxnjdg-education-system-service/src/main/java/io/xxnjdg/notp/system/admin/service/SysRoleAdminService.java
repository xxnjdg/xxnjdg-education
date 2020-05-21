package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.SysRoleBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysRoleDTO;
import io.xxnjdg.notp.system.object.persistent.SysRole;
import io.xxnjdg.notp.utils.response.PageResult;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 15:54
 */
public interface SysRoleAdminService extends IService<SysRole> {
    /**
     * 分页查询SysRole列表
     * @param sysRoleDTO
     * @return
     */
    PageResult<SysRoleBO> listSysRoleByPage(SysRoleDTO sysRoleDTO);

    /**
     * 插入
     * @param sysRoleDTO
     * @return
     */
    Boolean saveSysRole(SysRoleDTO sysRoleDTO);

    /**
     * 更新
     * @param sysRoleDTO
     * @return
     */
    Boolean updateSysRoleById(SysRoleDTO sysRoleDTO);

    /**
     * 查询
     * @param sysRoleDTO
     * @return
     */
    SysRoleBO getSysRoleById(SysRoleDTO sysRoleDTO);

    /**
     * UserId 获取 SysRoleBO
     * @param sysRoleDTO
     * @return
     */
    List<SysRoleBO> listSysRoleByUserId(SysRoleDTO sysRoleDTO);

    /**
     * 删除
     * @param sysRoleDTO
     * @return
     */
    Boolean deleteSysRoleById(SysRoleDTO sysRoleDTO);
}
