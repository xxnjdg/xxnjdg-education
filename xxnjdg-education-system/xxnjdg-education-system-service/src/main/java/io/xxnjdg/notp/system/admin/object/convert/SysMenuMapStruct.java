package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.SysMenuBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysMenuDTO;
import io.xxnjdg.notp.system.admin.object.view.SysMenuPageVO;
import io.xxnjdg.notp.system.admin.object.view.SysMenuVO;
import io.xxnjdg.notp.system.object.persistent.SysMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 22:11
 */
@Mapper
public interface SysMenuMapStruct {
    SysMenuMapStruct INSTANCE = Mappers.getMapper(SysMenuMapStruct.class);

    /**
     * P2B
     * @param sysMenuDTO
     * @return
     */
    SysMenu DTO2B(SysMenuDTO sysMenuDTO);

    /**
     * P2B
     * @param sysMenu
     * @return
     */
    SysMenuBO P2B(SysMenu sysMenu);


    /**
     * P2B
     * @param sysMenuList
     * @return
     */
    List<SysMenuBO> P2B(List<SysMenu> sysMenuList);

    /**
     * B2V
     * @param sysMenuBO
     * @return
     */
    SysMenuVO B2V(SysMenuBO sysMenuBO);

    /**
     * B2V
     * @param sysMenuBO
     * @return
     */
    SysMenuPageVO B2PV(SysMenuBO sysMenuBO);

    /**
     * B2V
     * @param sysMenuBOList
     * @return
     */
    List<SysMenuPageVO> B2PV(List<SysMenuBO> sysMenuBOList);
}