package io.xxnjdg.notp.system.service;

import io.xxnjdg.notp.system.object.business.SysMenuBO;
import io.xxnjdg.notp.system.object.data.transfer.SysMenuDTO;
import io.xxnjdg.notp.system.object.persistent.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * ids 查询 SysMenu 列表
     * @param sysMenuDTO
     * @return
     */
    List<SysMenuBO> listSysMenuByIds(SysMenuDTO sysMenuDTO);

    /**
     * 查询 sysmenu 的 button 列表
     * @param sysMenuDTO
     * @return
     */
    List<SysMenuBO> listButton(SysMenuDTO sysMenuDTO);

    /**
     * 查询 sysmenu 的 目录和菜单 列表
     * @param sysMenuDTO
     * @return
     */
    List<SysMenuBO> listDirectoryAndMenu(SysMenuDTO sysMenuDTO);
}
