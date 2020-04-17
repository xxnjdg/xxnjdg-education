package io.xxnjdg.notp.user.service.impl;

import io.xxnjdg.notp.user.entity.SendSmsLog;
import io.xxnjdg.notp.user.mapper.SendSmsLogMapper;
import io.xxnjdg.notp.user.service.SendSmsLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户发送短信日志 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class SendSmsLogServiceImpl extends ServiceImpl<SendSmsLogMapper, SendSmsLog> implements SendSmsLogService {

}
