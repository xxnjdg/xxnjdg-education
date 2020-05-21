package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.SysMenuRoleBO;
import io.xxnjdg.notp.system.admin.object.view.SysMenuRoleListVO;
import io.xxnjdg.notp.system.object.persistent.SysMenuRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 7:09
 */
@Mapper
public interface SysMenuRoleMapStruct {
    SysMenuRoleMapStruct INSTANCE = Mappers.getMapper(SysMenuRoleMapStruct.class);

    /**
     * P2B
     * @param sysMenuRole
     * @return
     */
    SysMenuRoleBO P2B(SysMenuRole sysMenuRole);


    /**
     * P2B
     * @param sysMenuRoleList
     * @return
     */
    List<SysMenuRoleBO> P2B(List<SysMenuRole> sysMenuRoleList);

    /**
     * B2V
     * @param sysMenuRole
     * @return
     */
    SysMenuRoleListVO B2LV(SysMenuRoleBO sysMenuRole);

    /**
     * B2V
     * @param sysLogBOList
     * @return
     */
//    List<SysLogVO> B2V(List<SysLogBO> sysLogBOList);

}