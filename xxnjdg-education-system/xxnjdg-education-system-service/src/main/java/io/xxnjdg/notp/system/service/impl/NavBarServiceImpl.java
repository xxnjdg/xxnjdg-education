package io.xxnjdg.notp.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.object.persistent.NavBar;
import io.xxnjdg.notp.system.mapper.NavBarMapper;
import io.xxnjdg.notp.system.service.NavBarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.ItemStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 头部导航 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class NavBarServiceImpl extends ServiceImpl<NavBarMapper, NavBar> implements NavBarService {

    @Override
    public List<NavBar> getNavBarList() {
        return this.list(new QueryWrapper<NavBar>().lambda().eq(NavBar::getStatusId, ItemStatus.ENABLE.getStatus()));
    }
}
