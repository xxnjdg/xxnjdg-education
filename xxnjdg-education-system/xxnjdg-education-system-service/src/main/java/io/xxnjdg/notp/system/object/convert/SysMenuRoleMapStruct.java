package io.xxnjdg.notp.system.object.convert;

import io.xxnjdg.notp.system.object.business.SysMenuRoleBO;
import io.xxnjdg.notp.system.object.persistent.SysMenuRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/15 20:32
 */
@Mapper
public interface SysMenuRoleMapStruct {
    SysMenuRoleMapStruct INSTANCE = Mappers.getMapper(SysMenuRoleMapStruct.class);

    /**
     * DO -> BO
     * @param sysMenuRoles
     * @return
     */
    List<SysMenuRoleBO> convertD2B(List<SysMenuRole> sysMenuRoles);
}