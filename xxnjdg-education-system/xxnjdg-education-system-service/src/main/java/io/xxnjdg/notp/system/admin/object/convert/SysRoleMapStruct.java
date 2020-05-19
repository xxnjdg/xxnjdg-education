package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.SysRoleBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysRoleDTO;
import io.xxnjdg.notp.system.admin.object.view.SysRolePageVO;
import io.xxnjdg.notp.system.admin.object.view.SysRoleVO;
import io.xxnjdg.notp.system.object.persistent.SysRole;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 15:57
 */
@Mapper
public interface SysRoleMapStruct {
    SysRoleMapStruct INSTANCE = Mappers.getMapper(SysRoleMapStruct.class);

    /**
     * P2B
     * @param sysRoleDTO
     * @return
     */
    SysRole P2B(SysRoleDTO sysRoleDTO);

    /**
     * P2B
     * @param sysRole
     * @return
     */
    SysRoleBO P2B(SysRole sysRole);


    /**
     * P2B
     * @param sysRoleList
     * @return
     */
    List<SysRoleBO> P2B(List<SysRole> sysRoleList);

    /**
     * B2V
     * @param sysRoleBO
     * @return
     */
    SysRolePageVO B2PV(SysRoleBO sysRoleBO);

    /**
     * B2V
     * @param sysRoleBOList
     * @return
     */
    List<SysRolePageVO> B2PV(List<SysRoleBO> sysRoleBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<SysRolePageVO> B2PV(PageResult<SysRoleBO> result);

    /**
     * B2V
     * @param sysRoleBO
     * @return
     */
    SysRoleVO B2V(SysRoleBO sysRoleBO);

    /**
     * B2V
     * @param sysRoleBOList
     * @return
     */
    List<SysRoleVO> B2V(List<SysRoleBO> sysRoleBOList);
}