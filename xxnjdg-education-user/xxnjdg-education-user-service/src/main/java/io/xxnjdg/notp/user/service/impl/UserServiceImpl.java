package io.xxnjdg.notp.user.service.impl;

import io.xxnjdg.notp.user.entity.User;
import io.xxnjdg.notp.user.mapper.UserMapper;
import io.xxnjdg.notp.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
