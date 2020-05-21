package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.NavBarBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.NavBarDTO;
import io.xxnjdg.notp.system.object.persistent.NavBar;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 16:03
 */
public interface NavBarAdminService extends IService<NavBar> {
    /**
     * 分页查询NavBar列表
     * @param navBarDTO
     * @return
     */
    PageResult<NavBarBO> listNavBarByPage(NavBarDTO navBarDTO);

    /**
     * 插入
     * @param navBarDTO
     * @return
     */
    Boolean saveNavBar(NavBarDTO navBarDTO);

    /**
     * 更新
     * @param navBarDTO
     * @return
     */
    Boolean updateNavBarById(NavBarDTO navBarDTO);

    /**
     * 山粗
     * @param navBarDTO
     * @return
     */
    Boolean deleteNavBarById(NavBarDTO navBarDTO);

    /**
     * 查询
     * @param navBarDTO
     * @return
     */
    NavBarBO getNavBarById(NavBarDTO navBarDTO);
}
