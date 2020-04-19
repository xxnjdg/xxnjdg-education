package io.xxnjdg.notp.user.service.impl;

import io.xxnjdg.notp.user.object.persistent.UserLogLogin;
import io.xxnjdg.notp.user.mapper.UserLogLoginMapper;
import io.xxnjdg.notp.user.service.UserLogLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户错误登录日志 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Service
public class UserLogLoginServiceImpl extends ServiceImpl<UserLogLoginMapper, UserLogLogin> implements UserLogLoginService {

}
