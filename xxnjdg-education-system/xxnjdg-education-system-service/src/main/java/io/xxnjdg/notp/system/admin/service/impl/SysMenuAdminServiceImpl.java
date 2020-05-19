package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.SysMenuBO;
import io.xxnjdg.notp.system.admin.object.convert.SysMenuMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysMenuDTO;
import io.xxnjdg.notp.system.admin.object.error.SysMenuEnum;
import io.xxnjdg.notp.system.admin.service.SysMenuAdminService;
import io.xxnjdg.notp.system.mapper.SysMenuMapper;
import io.xxnjdg.notp.system.object.persistent.SysMenu;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.ParentId;
import io.xxnjdg.notp.utils.custom.utils.ListToTreeUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 22:05
 */
@Service
public class SysMenuAdminServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuAdminService {
    @Override
    public List<SysMenuBO> listSysMenu(SysMenuDTO sysMenuDTO) {
        LambdaQueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>()
                .lambda();

        List<SysMenuBO> sysMenuBOList =
                SysMenuMapStruct.INSTANCE.P2B(this.list(wrapper));

        if (StrUtil.isBlank(sysMenuDTO.getMenuName())){
            try {
                sysMenuBOList = ListToTreeUtil.getTree(sysMenuBOList, ParentId.ZERO_PARENT_ID.getStatus());
            } catch (Exception e) {
                throw new BaseException(HttpStatus.ERROR.getStatus(),e.getMessage());
            }
            return sysMenuBOList;
        }

        wrapper.like(SysMenu::getMenuName,sysMenuDTO.getMenuName());
        List<SysMenuBO> menuNameBOList =
                SysMenuMapStruct.INSTANCE.P2B(this.list(wrapper));

        try {
            ListToTreeUtil.fillTree(menuNameBOList,sysMenuBOList,ParentId.ZERO_PARENT_ID.getStatus());
        } catch (Exception e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(),e.getMessage());
        }

        return menuNameBOList;
    }

    @Override
    public Boolean saveSysMenu(SysMenuDTO sysMenuDTO) {
        SysMenu sysMenu = SysMenuMapStruct.INSTANCE.DTO2B(sysMenuDTO);
        boolean save = this.save(sysMenu);
        if (!save){
            throw new BaseException(SysMenuEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteSysMenuById(SysMenuDTO sysMenuDTO) {
        List<SysMenu> sysMenuList = this.list();
        if (CollUtil.isEmpty(sysMenuList)){
            throw new BaseException(SysMenuEnum.DELETE_ERROR);
        }
        ArrayList<Long> list = new ArrayList<>();
        list.add(sysMenuDTO.getId());
        deleteChildren(sysMenuList, list, sysMenuDTO.getId());
        boolean remove = this.removeByIds(list);
        if (!remove){
            throw new BaseException(SysMenuEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean updateSysMenuById(SysMenuDTO sysMenuDTO) {
        SysMenu sysMenu = SysMenuMapStruct.INSTANCE.DTO2B(sysMenuDTO);
        boolean update = this.updateById(sysMenu);
        if (!update){
            throw new BaseException(SysMenuEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public SysMenuBO getSysMenuById(SysMenuDTO sysMenuDTO) {
        SysMenu sysMenu = this.getById(sysMenuDTO.getId());
        if (sysMenu == null){
            throw new BaseException(SysMenuEnum.GET_ERROR);
        }
        return SysMenuMapStruct.INSTANCE.P2B(sysMenu);
    }

    private void deleteChildren(List<SysMenu> sysMenuList, ArrayList<Long> list, Long id) {
        sysMenuList.forEach(sysMenu -> {
            if (ObjectUtil.equal(id,sysMenu.getParentId())){
                list.add(sysMenu.getId());
                if (sysMenu.getMenuType() < 3){
                    deleteChildren(sysMenuList,list,sysMenu.getId());
                }
            }
        });
    }


}
