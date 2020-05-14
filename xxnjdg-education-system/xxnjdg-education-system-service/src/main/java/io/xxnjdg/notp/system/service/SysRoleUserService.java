package io.xxnjdg.notp.system.service;

import io.xxnjdg.notp.system.object.business.SysRoleUserBO;
import io.xxnjdg.notp.system.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.object.persistent.SysRoleUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色用户关联表 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface SysRoleUserService extends IService<SysRoleUser> {

    /**
     * 查询 SysRoleUser 列表
     * @param sysRoleUserDTO
     * @return
     */
    List<SysRoleUserBO> listSysRoleUser(SysRoleUserDTO sysRoleUserDTO);

}
