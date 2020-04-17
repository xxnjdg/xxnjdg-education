package io.xxnjdg.notp.system.service.impl;

import io.xxnjdg.notp.system.object.persistent.MsgUser;
import io.xxnjdg.notp.system.mapper.MsgUserMapper;
import io.xxnjdg.notp.system.service.MsgUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 站内信用户记录表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class MsgUserServiceImpl extends ServiceImpl<MsgUserMapper, MsgUser> implements MsgUserService {

}
