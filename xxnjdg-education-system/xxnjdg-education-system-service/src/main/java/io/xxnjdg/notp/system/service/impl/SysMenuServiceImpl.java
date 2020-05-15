package io.xxnjdg.notp.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.object.business.SysMenuBO;
import io.xxnjdg.notp.system.object.convert.SysMenuMapStruct;
import io.xxnjdg.notp.system.object.data.transfer.SysMenuDTO;
import io.xxnjdg.notp.system.object.persistent.SysMenu;
import io.xxnjdg.notp.system.mapper.SysMenuMapper;
import io.xxnjdg.notp.system.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<SysMenuBO> listSysMenuByIds(SysMenuDTO sysMenuDTO) {

        LambdaQueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>()
                .lambda()
                .eq(SysMenu::getStatusId, RowStatus.ENABLE)
                .in(SysMenu::getId, sysMenuDTO.getIds());

        List<SysMenu> list = this.list(wrapper);

        return SysMenuMapStruct.INSTANCE.convertD2B(list);
    }
}
