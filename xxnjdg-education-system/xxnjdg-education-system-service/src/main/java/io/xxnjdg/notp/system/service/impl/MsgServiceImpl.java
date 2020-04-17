package io.xxnjdg.notp.system.service.impl;

import io.xxnjdg.notp.system.object.persistent.Msg;
import io.xxnjdg.notp.system.mapper.MsgMapper;
import io.xxnjdg.notp.system.service.MsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 站内信息表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class MsgServiceImpl extends ServiceImpl<MsgMapper, Msg> implements MsgService {

}
