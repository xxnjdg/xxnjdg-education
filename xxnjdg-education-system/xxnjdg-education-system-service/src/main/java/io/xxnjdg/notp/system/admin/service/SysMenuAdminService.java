package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.SysMenuBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysMenuDTO;
import io.xxnjdg.notp.system.object.persistent.SysMenu;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 22:04
 */
public interface SysMenuAdminService extends IService<SysMenu> {
    /**
     * 查询SysMenu列表
     * @param sysMenuDTO
     * @return
     */
    List<SysMenuBO> listSysMenu(SysMenuDTO sysMenuDTO);

    /**
     * 插入SysMenu
     * @param sysMenuDTO
     * @return
     */
    Boolean saveSysMenu(SysMenuDTO sysMenuDTO);

    /**
     * 删除
     * @param sysMenuDTO
     * @return
     */
    Boolean deleteSysMenuById(SysMenuDTO sysMenuDTO);

    /**
     * 更新
     * @param sysMenuDTO
     * @return
     */
    Boolean updateSysMenuById(SysMenuDTO sysMenuDTO);

    /**
     * 查询
     * @param sysMenuDTO
     * @return
     */
    SysMenuBO getSysMenuById(SysMenuDTO sysMenuDTO);
}
