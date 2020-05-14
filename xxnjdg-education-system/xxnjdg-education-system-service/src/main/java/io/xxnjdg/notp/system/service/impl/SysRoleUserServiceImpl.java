package io.xxnjdg.notp.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.object.business.SysRoleUserBO;
import io.xxnjdg.notp.system.object.convert.SysRoleUserMapStruct;
import io.xxnjdg.notp.system.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.object.persistent.SysRoleUser;
import io.xxnjdg.notp.system.mapper.SysRoleUserMapper;
import io.xxnjdg.notp.system.objects.error.SysRoleUserEnum;
import io.xxnjdg.notp.system.service.SysRoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色用户关联表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class SysRoleUserServiceImpl extends ServiceImpl<SysRoleUserMapper, SysRoleUser> implements SysRoleUserService {

    @Override
    public List<SysRoleUserBO> listSysRoleUser(SysRoleUserDTO sysRoleUserDTO) {

        LambdaQueryWrapper<SysRoleUser> wrapper = new QueryWrapper<SysRoleUser>()
                .lambda()
                .eq(SysRoleUser::getUserId, sysRoleUserDTO.getUserId())
                .eq(SysRoleUser::getStatusId, RowStatus.ENABLE);

        List<SysRoleUser> list = this.list(wrapper);

        return SysRoleUserMapStruct.INSTANCE.convertD2B(list);
    }
}
