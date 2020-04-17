package io.xxnjdg.notp.system.service.impl;

import io.xxnjdg.notp.system.object.persistent.SysUser;
import io.xxnjdg.notp.system.mapper.SysUserMapper;
import io.xxnjdg.notp.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
