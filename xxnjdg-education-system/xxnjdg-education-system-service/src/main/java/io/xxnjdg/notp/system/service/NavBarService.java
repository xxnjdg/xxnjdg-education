package io.xxnjdg.notp.system.service;

import io.xxnjdg.notp.system.object.persistent.NavBar;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 头部导航 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface NavBarService extends IService<NavBar> {

    /**
     * 11
     * @return
     */
    List<NavBar> getNavBarList();
}
