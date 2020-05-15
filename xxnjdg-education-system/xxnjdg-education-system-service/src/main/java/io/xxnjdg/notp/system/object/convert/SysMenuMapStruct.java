package io.xxnjdg.notp.system.object.convert;

import io.xxnjdg.notp.system.object.business.SysMenuBO;
import io.xxnjdg.notp.system.object.persistent.SysMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/15 20:57
 */
@Mapper
public interface SysMenuMapStruct {
    SysMenuMapStruct INSTANCE = Mappers.getMapper(SysMenuMapStruct.class);

    /**
     * DO -> BO
     * @param sysMenuRoles
     * @return
     */
    List<SysMenuBO> convertD2B(List<SysMenu> sysMenuRoles);
}