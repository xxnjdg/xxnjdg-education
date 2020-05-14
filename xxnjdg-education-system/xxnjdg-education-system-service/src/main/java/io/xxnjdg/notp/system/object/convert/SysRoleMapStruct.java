package io.xxnjdg.notp.system.object.convert;

import io.xxnjdg.notp.system.object.business.SysRoleBO;
import io.xxnjdg.notp.system.object.persistent.SysRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-14 下午9:37
 */
@Mapper
public interface SysRoleMapStruct {
    SysRoleMapStruct INSTANCE = Mappers.getMapper(SysRoleMapStruct.class);

    /**
     * DO -> BO
     * @param sysRoleUsers
     * @return
     */
    List<SysRoleBO> convertD2B(List<SysRole> sysRoleUsers);
}