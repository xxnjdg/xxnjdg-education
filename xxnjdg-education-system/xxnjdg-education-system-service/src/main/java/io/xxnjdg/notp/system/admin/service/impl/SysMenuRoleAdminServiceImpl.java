package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.SysMenuRoleBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysMenuRoleDTO;
import io.xxnjdg.notp.system.admin.object.error.SysMenuRoleEnum;
import io.xxnjdg.notp.system.admin.service.SysMenuRoleAdminService;
import io.xxnjdg.notp.system.mapper.SysMenuRoleMapper;
import io.xxnjdg.notp.system.object.persistent.SysMenuRole;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 7:05
 */
@Service
public class SysMenuRoleAdminServiceImpl extends ServiceImpl<SysMenuRoleMapper, SysMenuRole> implements SysMenuRoleAdminService {
    @Override
    public SysMenuRoleBO listSysMenuRole(SysMenuRoleDTO sysMenuRoleDTO) {
        LambdaQueryWrapper<SysMenuRole> wrapper = new QueryWrapper<SysMenuRole>()
                .lambda()
                .eq(SysMenuRole::getRoleId, sysMenuRoleDTO.getRoleId());

        List<SysMenuRole> sysMenuRoleList = this.list(wrapper);
        if (CollUtil.isEmpty(sysMenuRoleList)){
            return null;
        }

        List<String> list = sysMenuRoleList.stream().map(sysMenuRole ->
                String.valueOf(sysMenuRole.getMenuId())).collect(Collectors.toList());


        return new SysMenuRoleBO().setList(list);
    }

    @Override
    @Transactional
    public Boolean saveSysMenuRole(SysMenuRoleDTO sysMenuRoleDTO) {
        this.deleteSysMenuRoleByRoleId(sysMenuRoleDTO);

        Long roleId = sysMenuRoleDTO.getRoleId();
        List<SysMenuRole> menuRoleList = sysMenuRoleDTO.getMenuIds().stream()
                .map(menuId -> new SysMenuRole().setMenuId(menuId).setRoleId(roleId))
                .collect(Collectors.toList());

        boolean saveBatch = this.saveBatch(menuRoleList);
        if (!saveBatch){
            throw new BaseException(SysMenuRoleEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean deleteSysMenuRoleByRoleId(SysMenuRoleDTO sysMenuRoleDTO) {
        LambdaQueryWrapper<SysMenuRole> wrapper = new QueryWrapper<SysMenuRole>()
                .lambda()
                .eq(SysMenuRole::getRoleId, sysMenuRoleDTO.getRoleId());

        boolean remove = this.remove(wrapper);
        if (!remove){
            throw new BaseException(SysMenuRoleEnum.DELETE_ERROR);
        }
        return true;
    }


}
