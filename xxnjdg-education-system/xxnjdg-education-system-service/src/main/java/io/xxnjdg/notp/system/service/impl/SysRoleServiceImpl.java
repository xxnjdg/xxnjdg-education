package io.xxnjdg.notp.system.service.impl;

import io.xxnjdg.notp.system.object.business.SysRoleBO;
import io.xxnjdg.notp.system.object.convert.SysRoleMapStruct;
import io.xxnjdg.notp.system.object.data.transfer.SysRoleDTO;
import io.xxnjdg.notp.system.object.persistent.SysRole;
import io.xxnjdg.notp.system.mapper.SysRoleMapper;
import io.xxnjdg.notp.system.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public List<SysRoleBO> getSysRoleByIds(SysRoleDTO sysRoleDTO) {
        List<SysRole> sysRoles = this.listByIds(sysRoleDTO.getIds());
        return SysRoleMapStruct.INSTANCE.convertD2B(sysRoles);
    }
}
