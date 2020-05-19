package io.xxnjdg.notp.system.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.SysRoleUserBO;
import io.xxnjdg.notp.system.admin.object.convert.SysRoleUserMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.admin.object.error.SysRoleUserEnum;
import io.xxnjdg.notp.system.admin.service.SysRoleUserAdminService;
import io.xxnjdg.notp.system.mapper.SysRoleUserMapper;
import io.xxnjdg.notp.system.object.persistent.SysRoleUser;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 15:00
 */
@Service
public class SysRoleUserAdminServiceImpl extends ServiceImpl<SysRoleUserMapper, SysRoleUser> implements SysRoleUserAdminService {

    @Override
    public List<SysRoleUserBO> listSysRoleUserByUserId(SysRoleUserDTO sysRoleUserDTO) {
        LambdaQueryWrapper<SysRoleUser> wrapper = new QueryWrapper<SysRoleUser>()
                .lambda()
                .eq(SysRoleUser::getUserId, sysRoleUserDTO.getUserId());
        return SysRoleUserMapStruct.INSTANCE.P2B(this.list(wrapper));
    }

    @Override
    @Transactional
    public Boolean saveSysRoleUser(SysRoleUserDTO sysRoleUserDTO) {
        //先删除
        this.deleteSysRoleUserByUserId(sysRoleUserDTO);
        SysRoleUser sysRoleUser = SysRoleUserMapStruct.INSTANCE.DTO2P(sysRoleUserDTO);
        sysRoleUserDTO.getRoleIds().forEach(roleId -> {
            boolean save = this.save(sysRoleUser.setRoleId(roleId));
            if (!save){
                throw new BaseException(SysRoleUserEnum.SAVE_ERROR);
            }
        });
        return true;
    }

    @Override
    public Boolean deleteSysRoleUserByUserId(SysRoleUserDTO sysRoleUserDTO) {
        LambdaQueryWrapper<SysRoleUser> wrapper = new QueryWrapper<SysRoleUser>()
                .lambda()
                .eq(SysRoleUser::getUserId, sysRoleUserDTO.getUserId());

        boolean remove = this.remove(wrapper);
        if (!remove){
            throw new BaseException(SysRoleUserEnum.DELETE_ERROR);
        }
        return true;
    }
}
