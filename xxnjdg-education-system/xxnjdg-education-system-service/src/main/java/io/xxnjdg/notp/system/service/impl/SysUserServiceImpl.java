package io.xxnjdg.notp.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.object.business.*;
import io.xxnjdg.notp.system.object.convert.SysUserMapStruct;
import io.xxnjdg.notp.system.object.data.transfer.SysMenuDTO;
import io.xxnjdg.notp.system.object.data.transfer.SysMenuRoleDTO;
import io.xxnjdg.notp.system.object.data.transfer.SysRoleDTO;
import io.xxnjdg.notp.system.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.objects.error.SysUserEnum;
import io.xxnjdg.notp.system.object.persistent.SysUser;
import io.xxnjdg.notp.system.mapper.SysUserMapper;
import io.xxnjdg.notp.system.objects.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysRoleUserService sysRoleUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuRoleService sysMenuRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public SysUserBO listMenuApiUrl(SysUserDTO sysUserDTO) {

        //查询 SysUser
        SysUserBO sysUserBO = this.getSysUserByUserNo(sysUserDTO);

        //查询用户和角色中间表
        List<SysRoleUserBO> sysRoleUserBOS = sysRoleUserService
                .listSysRoleUser(new SysRoleUserDTO().setUserId(sysUserBO.getId()));

        if (CollUtil.isEmpty(sysRoleUserBOS)){
            return null;
        }

        //查询角色和菜单中间表
        Set<Long> roleIds = sysRoleUserBOS.stream().map(SysRoleUserBO::getRoleId).collect(Collectors.toSet());
        List<SysMenuRoleBO> sysMenuRoleBOS = sysMenuRoleService.listSysMenuRole(
                new SysMenuRoleDTO().setRoleIds(roleIds));

        if (CollUtil.isEmpty(sysMenuRoleBOS)){
            return null;
        }

        //查询菜单
        Set<Long> meneIds = sysMenuRoleBOS.stream()
                .map(SysMenuRoleBO::getMenuId)
                .collect(Collectors.toSet());

        List<SysMenuBO> sysMenuBOS =
                sysMenuService.listSysMenuByIds(new SysMenuDTO().setIds(meneIds));

        if (CollUtil.isEmpty(sysMenuBOS)){
            return null;
        }

        ArrayList<String> list = new ArrayList<>();

        sysMenuBOS.forEach(sysMenuBO -> list.add(sysMenuBO.getApiUrl()));

        return sysUserBO.setListMenuApiUrl(list);
    }

    @Override
    public SysUserBO getSysUserByUserNo(SysUserDTO sysUserDTO) {
        //查询 SysUser
        LambdaQueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>()
                .lambda()
                .eq(SysUser::getStatusId, RowStatus.ENABLE)
                .eq(SysUser::getUserNo, sysUserDTO.getUserNo());

        SysUser one = this.getOne(wrapper);

        if (one == null){
            throw new BaseException(SysUserEnum.GET_ERROR);
        }

        return SysUserMapStruct.INSTANCE.convertD2B(one);
    }
}
