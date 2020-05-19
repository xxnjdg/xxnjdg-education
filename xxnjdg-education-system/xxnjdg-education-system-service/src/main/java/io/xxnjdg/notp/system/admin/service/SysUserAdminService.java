package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.SysUserBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.object.persistent.SysUser;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 2:58
 */
public interface SysUserAdminService extends IService<SysUser> {
    /**
     * 分页查询SysUser列表
     * @param sysUserDTO
     * @return
     */
    PageResult<SysUserBO> listSysUserByPage(SysUserDTO sysUserDTO);

    /**
     * 插入SysUser
     * @param sysUserDTO
     * @return
     */
    Boolean saveSysUser(SysUserDTO sysUserDTO);

    /**
     * 删除SysUser
     * @param sysUserDTO
     * @return
     */
    Boolean deleteSysUserById(SysUserDTO sysUserDTO);

    /**
     * 更新
     * @param sysUserDTO
     * @return
     */
    Boolean updateSysUserById(SysUserDTO sysUserDTO);

    /**
     * 查询
     * @param sysUserDTO
     * @return
     */
    SysUserBO getSysUserById(SysUserDTO sysUserDTO);
}
