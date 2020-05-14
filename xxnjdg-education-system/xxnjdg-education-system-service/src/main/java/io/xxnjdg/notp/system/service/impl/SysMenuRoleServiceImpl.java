package io.xxnjdg.notp.system.service.impl;

import io.xxnjdg.notp.system.object.business.SysMenuRoleBO;
import io.xxnjdg.notp.system.object.data.transfer.SysMenuRoleDTO;
import io.xxnjdg.notp.system.object.persistent.SysMenuRole;
import io.xxnjdg.notp.system.mapper.SysMenuRoleMapper;
import io.xxnjdg.notp.system.service.SysMenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单角色关联表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class SysMenuRoleServiceImpl extends ServiceImpl<SysMenuRoleMapper, SysMenuRole> implements SysMenuRoleService {

    @Override
    public SysMenuRoleBO listSysMenuRole(SysMenuRoleDTO sysMenuRoleDTO) {

//        this.baseMapper.selectByMap()

        return null;
    }
}
