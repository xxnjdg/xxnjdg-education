package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.SysRoleBO;
import io.xxnjdg.notp.system.admin.object.business.SysRoleUserBO;
import io.xxnjdg.notp.system.admin.object.convert.SysRoleMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysRoleDTO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.admin.object.error.SysRoleEnum;
import io.xxnjdg.notp.system.admin.service.SysRoleAdminService;
import io.xxnjdg.notp.system.admin.service.SysRoleUserAdminService;
import io.xxnjdg.notp.system.mapper.SysRoleMapper;
import io.xxnjdg.notp.system.object.persistent.SysRole;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 15:55
 */
@Service
public class SysRoleAdminServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleAdminService {

    @Autowired
    private SysRoleUserAdminService sysRoleUserAdminService;

    @Override
    public PageResult<SysRoleBO> listSysRoleByPage(SysRoleDTO sysRoleDTO) {
        PageResult<SysRoleBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<SysRole> wrapper = new QueryWrapper<SysRole>()
                .lambda();

        String roleName = null;
        Integer statusId = null;

        if (StrUtil.isNotBlank(sysRoleDTO.getRoleName())) {
            roleName = sysRoleDTO.getRoleName();
            wrapper.like(SysRole::getRoleName, roleName);
        }

        if (sysRoleDTO.getStatusId() != null) {
            statusId = sysRoleDTO.getStatusId();
            wrapper.eq(SysRole::getStatusId,statusId);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                sysRoleDTO.getPageCurrent(), sysRoleDTO.getPageSize(), count);

        //查询
        List<SysRole> sysRoleList =
                this.baseMapper.listSysRoleByPage(roleName, statusId, pageObject.getOffset(), pageObject.getSize());

        List<SysRoleBO> sysRoleBOList = SysRoleMapStruct.INSTANCE.P2B(sysRoleList);

        return result
                .setCurrentList(sysRoleBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) sysRoleList.size());
    }

    @Override
    public Boolean saveSysRole(SysRoleDTO sysRoleDTO) {
        SysRole sysRole = SysRoleMapStruct.INSTANCE.P2B(sysRoleDTO);
        boolean save = this.save(sysRole);
        if (!save) {
            throw new BaseException(SysRoleEnum.GET_ERROR);
        }
        return true;
    }

    @Override
    public Boolean updateSysRoleById(SysRoleDTO sysRoleDTO) {
        SysRole sysRole = SysRoleMapStruct.INSTANCE.P2B(sysRoleDTO);
        boolean update = this.updateById(sysRole);
        if (!update) {
            throw new BaseException(SysRoleEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public SysRoleBO getSysRoleById(SysRoleDTO sysRoleDTO) {
        SysRole sysRole = this.getById(sysRoleDTO.getId());
        if (sysRole == null) {
            throw new BaseException(SysRoleEnum.GET_ERROR);
        }
        return SysRoleMapStruct.INSTANCE.P2B(sysRole);
    }

    @Override
    public List<SysRoleBO> listSysRoleByUserId(SysRoleDTO sysRoleDTO) {
        List<SysRoleUserBO> sysRoleUserBOList = sysRoleUserAdminService.listSysRoleUserByUserId(
                new SysRoleUserDTO().setUserId(sysRoleDTO.getUserId()));
        ArrayList<SysRoleBO> list = new ArrayList<>();
        if (CollUtil.isNotEmpty(sysRoleUserBOList)){
            sysRoleUserBOList.forEach(sysRoleUserBO -> {
                list.add(this.getSysRoleById(sysRoleDTO.setId(sysRoleUserBO.getRoleId())));
            });
        }
        return list;
    }
}
