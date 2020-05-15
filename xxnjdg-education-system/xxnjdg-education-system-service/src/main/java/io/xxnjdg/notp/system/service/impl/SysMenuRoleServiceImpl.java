package io.xxnjdg.notp.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.object.business.SysMenuRoleBO;
import io.xxnjdg.notp.system.object.convert.SysMenuRoleMapStruct;
import io.xxnjdg.notp.system.object.data.transfer.SysMenuRoleDTO;
import io.xxnjdg.notp.system.object.persistent.SysMenuRole;
import io.xxnjdg.notp.system.mapper.SysMenuRoleMapper;
import io.xxnjdg.notp.system.service.SysMenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<SysMenuRoleBO> listSysMenuRole(SysMenuRoleDTO sysMenuRoleDTO) {

        LambdaQueryWrapper<SysMenuRole> wrapper = new QueryWrapper<SysMenuRole>()
                .lambda()
                .eq(SysMenuRole::getStatusId, RowStatus.ENABLE)
                .in(SysMenuRole::getRoleId, sysMenuRoleDTO.getRoleIds());

        List<SysMenuRole> list = this.list(wrapper);

        return SysMenuRoleMapStruct.INSTANCE.convertD2B(list);
    }
}
