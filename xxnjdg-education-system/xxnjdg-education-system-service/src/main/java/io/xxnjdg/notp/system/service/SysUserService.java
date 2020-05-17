package io.xxnjdg.notp.system.service;

import io.xxnjdg.notp.system.object.business.SysUserBO;
import io.xxnjdg.notp.system.object.persistent.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.objects.data.transfer.SysUserDTO;

/**
 * <p>
 * 后台用户信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 查询 SysUser 菜单 apiurl
     * @param sysUserDTO
     * @return
     */
    SysUserBO listMenuApiUrl(SysUserDTO sysUserDTO);


    /**
     * 使用UserNo查询
     * @param sysUserDTO
     * @return
     */
    SysUserBO getSysUserByUserNo(SysUserDTO sysUserDTO);
}
