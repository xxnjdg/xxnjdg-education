package io.xxnjdg.notp.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.object.business.SysRoleBO;
import io.xxnjdg.notp.system.object.business.SysRoleUserBO;
import io.xxnjdg.notp.system.object.business.SysUserBO;
import io.xxnjdg.notp.system.object.data.transfer.SysRoleDTO;
import io.xxnjdg.notp.system.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.objects.error.SysUserEnum;
import io.xxnjdg.notp.system.object.persistent.SysUser;
import io.xxnjdg.notp.system.mapper.SysUserMapper;
import io.xxnjdg.notp.system.objects.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.service.SysRoleService;
import io.xxnjdg.notp.system.service.SysRoleUserService;
import io.xxnjdg.notp.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public SysUserBO listMenuApiUrl(SysUserDTO sysUserDTO) {

        //查询 SysUser
        LambdaQueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>()
                .lambda()
                .eq(SysUser::getStatusId, RowStatus.ENABLE)
                .eq(SysUser::getUserNo, sysUserDTO.getUserNo());

        SysUser one = this.getOne(wrapper);

        if (one == null){
            throw new BaseException(SysUserEnum.GET_ERROR);
        }

        //查询用户和角色中间表
        List<SysRoleUserBO> sysRoleUserBOS = sysRoleUserService
                .listSysRoleUser(new SysRoleUserDTO().setUserId(one.getId()));

        if (CollUtil.isEmpty(sysRoleUserBOS)){
            return null;
        }

        //查询角色
        List<Long> ids = sysRoleUserBOS.stream()
                .map(SysRoleUserBO::getRoleId)
                .collect(Collectors.toList());

        List<SysRoleBO> sysRoleByIds = sysRoleService
                .getSysRoleByIds(new SysRoleDTO().setIds(ids));



        return null;
    }
}
