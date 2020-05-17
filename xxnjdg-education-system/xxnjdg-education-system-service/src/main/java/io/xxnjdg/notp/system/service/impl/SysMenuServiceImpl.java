package io.xxnjdg.notp.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.object.business.SysMenuBO;
import io.xxnjdg.notp.system.object.business.SysMenuRoleBO;
import io.xxnjdg.notp.system.object.business.SysRoleUserBO;
import io.xxnjdg.notp.system.object.business.SysUserBO;
import io.xxnjdg.notp.system.object.convert.SysMenuMapStruct;
import io.xxnjdg.notp.system.object.data.transfer.SysMenuDTO;
import io.xxnjdg.notp.system.object.data.transfer.SysMenuRoleDTO;
import io.xxnjdg.notp.system.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.object.persistent.SysMenu;
import io.xxnjdg.notp.system.mapper.SysMenuMapper;
import io.xxnjdg.notp.system.objects.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.objects.error.SysMenuEnum;
import io.xxnjdg.notp.system.service.SysMenuRoleService;
import io.xxnjdg.notp.system.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.service.SysRoleUserService;
import io.xxnjdg.notp.system.service.SysUserService;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.MenuType;
import io.xxnjdg.notp.utils.constant.ParentId;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.ListToTreeUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleUserService sysRoleUserService;

    @Autowired
    private SysMenuRoleService sysMenuRoleService;

    @Override
    public List<SysMenuBO> listSysMenuByIds(SysMenuDTO sysMenuDTO) {

        LambdaQueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>()
                .lambda()
                .eq(SysMenu::getStatusId, RowStatus.ENABLE)
                .in(SysMenu::getId, sysMenuDTO.getIds());

        List<SysMenu> list = this.list(wrapper);

        return SysMenuMapStruct.INSTANCE.convertD2B(list);
    }

    @Override
    public List<SysMenuBO> listButton(SysMenuDTO sysMenuDTO) {
        Set<Long> menuIds = getUserMenuIds(sysMenuDTO);

        List<SysMenuBO> sysMenuBOS = this.listButtonMenuType(sysMenuDTO.setMenuType(MenuType.BUTTON));

        if (CollUtil.isEmpty(sysMenuBOS)){
            throw new BaseException(SysMenuEnum.GET_ERROR);
        }

        return getUserMenu(menuIds, sysMenuBOS);
    }

    @Override
    public List<SysMenuBO> listDirectoryAndMenu(SysMenuDTO sysMenuDTO) {
        Set<Long> userMenuIds = this.getUserMenuIds(sysMenuDTO);

        List<SysMenuBO> sysMenuBOS = this.listNotButtonMenuType(new SysMenuDTO().setMenuType(MenuType.BUTTON));
        if (CollUtil.isEmpty(sysMenuBOS)){
            throw new BaseException(SysMenuEnum.GET_ERROR);
        }

        List<SysMenuBO> sysMenuBOList = getUserMenu(userMenuIds, sysMenuBOS);

        try {
            sysMenuBOList = ListToTreeUtil.getTree(sysMenuBOList,ParentId.ZERO_PARENT_ID.getStatus());
        } catch (Exception e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(),e.getMessage());
        }

        return sysMenuBOList;
    }


    private List<SysMenuBO> getUserMenu(Set<Long> menuIds, List<SysMenuBO> sysMenuBOS) {
        List<SysMenuBO> sysMenuBOList = new ArrayList<>();
        sysMenuBOS.forEach(sysMenuBO -> menuIds.forEach(aLong -> {
            if (ObjectUtil.equal(sysMenuBO.getId(), aLong)) {
                sysMenuBOList.add(sysMenuBO);
            }
        }));
        return sysMenuBOList;
    }

    private Set<Long> getUserMenuIds(SysMenuDTO sysMenuDTO) {
        SysUserBO sysUserBO = sysUserService.getSysUserByUserNo(
                new SysUserDTO().setUserNo(sysMenuDTO.getUserNo()));

        List<SysRoleUserBO> sysRoleUserBOS = sysRoleUserService.listSysRoleUser(
                new SysRoleUserDTO().setUserId(sysUserBO.getId()));

        if (CollUtil.isEmpty(sysRoleUserBOS)){
            throw new BaseException(SysMenuEnum.GET_ERROR);
        }

        Set<Long> roleIds = sysRoleUserBOS.stream()
                .map(SysRoleUserBO::getRoleId).collect(Collectors.toSet());

        List<SysMenuRoleBO> sysMenuRoleBOS = sysMenuRoleService.listSysMenuRole(
                new SysMenuRoleDTO().setRoleIds(roleIds));

        if (CollUtil.isEmpty(sysMenuRoleBOS)){
            throw new BaseException(SysMenuEnum.GET_ERROR);
        }

        return sysMenuRoleBOS.stream().map(SysMenuRoleBO::getMenuId)
                .collect(Collectors.toSet());
    }

    private List<SysMenuBO> listButtonMenuType(SysMenuDTO sysMenuDTO){
        LambdaQueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>()
                .lambda()
                .eq(SysMenu::getStatusId, RowStatus.ENABLE)
                .eq(SysMenu::getMenuType, sysMenuDTO.getMenuType());

        return SysMenuMapStruct.INSTANCE.convertD2B(this.list(wrapper));
    }

    private List<SysMenuBO> listNotButtonMenuType(SysMenuDTO sysMenuDTO){
        LambdaQueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>()
                .lambda()
                .eq(SysMenu::getStatusId, RowStatus.ENABLE)
                .lt(SysMenu::getMenuType,sysMenuDTO.getMenuType());

        return SysMenuMapStruct.INSTANCE.convertD2B(this.list(wrapper));
    }
}
