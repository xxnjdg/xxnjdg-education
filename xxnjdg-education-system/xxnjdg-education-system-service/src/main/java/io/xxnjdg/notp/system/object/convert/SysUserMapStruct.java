package io.xxnjdg.notp.system.object.convert;

import io.xxnjdg.notp.system.object.business.SysUserBO;
import io.xxnjdg.notp.system.object.persistent.SysUser;
import io.xxnjdg.notp.system.objects.view.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/15 21:51
 */
@Mapper
public interface SysUserMapStruct {
    SysUserMapStruct INSTANCE = Mappers.getMapper(SysUserMapStruct.class);

    /**
     * DO -> BO
     * @param sysUser
     * @return
     */
    SysUserBO convertD2B(SysUser sysUser);

    /**
     * DO -> BO
     * @param sysUserBO
     * @return
     */
    SysUserVO convertB2V(SysUserBO sysUserBO);

}