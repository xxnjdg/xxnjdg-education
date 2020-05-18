package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.SysUserBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.admin.object.view.SysUserPageVO;
import io.xxnjdg.notp.system.object.persistent.SysUser;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 3:03
 */
@Mapper
public interface SysUserMapStruct {
    SysUserMapStruct INSTANCE = Mappers.getMapper(SysUserMapStruct.class);

    /**
     * DTO2P
     * @param sysUserDTO
     * @return
     */
    SysUser DTO2P(SysUserDTO sysUserDTO);

    /**
     * P2B
     * @param sysUser
     * @return
     */
    SysUserBO P2B(SysUser sysUser);


    /**
     * P2B
     * @param sysUserList
     * @return
     */
    List<SysUserBO> P2B(List<SysUser> sysUserList);

    /**
     * B2V
     * @param sysUserBO
     * @return
     */
    SysUserPageVO B2PV(SysUserBO sysUserBO);

    /**
     * B2V
     * @param sysUserBOList
     * @return
     */
    List<SysUserPageVO> B2PV(List<SysUserBO> sysUserBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<SysUserPageVO> B2PV(PageResult<SysUserBO> result);
}