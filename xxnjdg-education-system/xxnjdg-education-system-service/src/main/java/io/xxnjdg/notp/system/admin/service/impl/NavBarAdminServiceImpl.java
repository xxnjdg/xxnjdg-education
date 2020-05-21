package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.NavBarBO;
import io.xxnjdg.notp.system.admin.object.convert.NavBarMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.NavBarDTO;
import io.xxnjdg.notp.system.admin.object.error.NavBarEnum;
import io.xxnjdg.notp.system.admin.service.NavBarAdminService;
import io.xxnjdg.notp.system.mapper.NavBarMapper;
import io.xxnjdg.notp.system.object.persistent.NavBar;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 16:04
 */
@Service
public class NavBarAdminServiceImpl extends ServiceImpl<NavBarMapper, NavBar> implements NavBarAdminService {
    @Override
    public PageResult<NavBarBO> listNavBarByPage(NavBarDTO navBarDTO) {
        PageResult<NavBarBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<NavBar> wrapper = new QueryWrapper<NavBar>()
                .lambda();

        Integer statusId = navBarDTO.getStatusId();
        String navTitle = null;

        if (statusId != null){
            wrapper.eq(NavBar::getStatusId,statusId);
        }

        if (StrUtil.isNotBlank(navBarDTO.getNavTitle())){
            navTitle = navBarDTO.getNavTitle();
            wrapper.like(NavBar::getNavTitle,navTitle);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                navBarDTO.getPageCurrent(), navBarDTO.getPageSize(), count);

        //查询
        List<NavBar> navBarList =
                this.baseMapper.listNavBarByPage(statusId,navTitle,pageObject.getOffset(), pageObject.getSize());

        List<NavBarBO> navBarBOList = NavBarMapStruct.INSTANCE.P2B(navBarList);

        return result
                .setCurrentList(navBarBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) navBarList.size());
    }

    @Override
    public Boolean saveNavBar(NavBarDTO navBarDTO) {
        // TODO: 2020/5/20 有问题
        LambdaQueryWrapper<NavBar> wrapper = new QueryWrapper<NavBar>()
                .lambda()
                .eq(NavBar::getNavUrl, navBarDTO.getNavUrl());

        NavBar one = this.getOne(wrapper);
        if (one!=null){
            throw new BaseException(NavBarEnum.GET_ERROR);
        }
        NavBar navBar = NavBarMapStruct.INSTANCE.DTO2P(navBarDTO);
        boolean save = this.save(navBar);
        if (!save){
            throw new BaseException(NavBarEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean updateNavBarById(NavBarDTO navBarDTO) {
        NavBar navBar = NavBarMapStruct.INSTANCE.DTO2P(navBarDTO);
        boolean update = this.updateById(navBar);
        if (!update){
            throw new BaseException(NavBarEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean deleteNavBarById(NavBarDTO navBarDTO) {
        boolean remove = this.removeById(navBarDTO.getId());
        if (!remove){
            throw new BaseException(NavBarEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public NavBarBO getNavBarById(NavBarDTO navBarDTO) {
        NavBar navBar = this.getById(navBarDTO.getId());
        if (navBar==null){
            throw new BaseException(NavBarEnum.GET_ERROR);
        }
        return NavBarMapStruct.INSTANCE.P2B(navBar);
    }
}
