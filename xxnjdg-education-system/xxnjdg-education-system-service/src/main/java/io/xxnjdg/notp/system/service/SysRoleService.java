package io.xxnjdg.notp.system.service;

import io.xxnjdg.notp.system.object.business.SysRoleBO;
import io.xxnjdg.notp.system.object.data.transfer.SysRoleDTO;
import io.xxnjdg.notp.system.object.persistent.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 查询 SysRole
     * @param sysRoleDTO
     * @return
     */
    List<SysRoleBO> getSysRoleByIds(SysRoleDTO sysRoleDTO);

}
