package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.SysRoleUserBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.admin.object.view.SysRoleUserVO;
import io.xxnjdg.notp.system.object.persistent.SysRoleUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 15:12
 */
@Mapper
public interface SysRoleUserMapStruct {
    SysRoleUserMapStruct INSTANCE = Mappers.getMapper(SysRoleUserMapStruct.class);

    /**
     * DTO2P
     * @param sysRoleUserDTO
     * @return
     */
    SysRoleUser DTO2P(SysRoleUserDTO sysRoleUserDTO);

    /**
     * P2B
     * @param sysRoleUser
     * @return
     */
    SysRoleUserBO P2B(SysRoleUser sysRoleUser);


    /**
     * P2B
     * @param sysRoleUserList
     * @return
     */
    List<SysRoleUserBO> P2B(List<SysRoleUser> sysRoleUserList);

    /**
     * B2V
     * @param sysRoleUserBO
     * @return
     */
    SysRoleUserVO B2V(SysRoleUserBO sysRoleUserBO);

    /**
     * B2V
     * @param sysRoleUserBOList
     * @return
     */
    List<SysRoleUserVO> B2V(List<SysRoleUserBO> sysRoleUserBOList);

}