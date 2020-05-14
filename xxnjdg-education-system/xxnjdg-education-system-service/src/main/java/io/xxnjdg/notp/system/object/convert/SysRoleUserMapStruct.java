package io.xxnjdg.notp.system.object.convert;

import io.xxnjdg.notp.system.object.business.SysRoleUserBO;
import io.xxnjdg.notp.system.object.persistent.SysRoleUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-14 下午8:37
 */
@Mapper
public interface SysRoleUserMapStruct {
    SysRoleUserMapStruct INSTANCE = Mappers.getMapper(SysRoleUserMapStruct.class);

    /**
     * DO -> BO
     * @param sysRoleUsers
     * @return
     */
    List<SysRoleUserBO> convertD2B(List<SysRoleUser> sysRoleUsers);
}