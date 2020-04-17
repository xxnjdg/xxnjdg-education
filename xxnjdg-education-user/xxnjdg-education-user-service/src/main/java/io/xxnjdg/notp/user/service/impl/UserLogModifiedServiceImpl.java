package io.xxnjdg.notp.user.service.impl;

import io.xxnjdg.notp.user.entity.UserLogModified;
import io.xxnjdg.notp.user.mapper.UserLogModifiedMapper;
import io.xxnjdg.notp.user.service.UserLogModifiedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户修改日志 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class UserLogModifiedServiceImpl extends ServiceImpl<UserLogModifiedMapper, UserLogModified> implements UserLogModifiedService {

}
