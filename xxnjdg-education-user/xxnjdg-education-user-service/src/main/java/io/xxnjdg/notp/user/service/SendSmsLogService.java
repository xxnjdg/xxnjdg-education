package io.xxnjdg.notp.user.service;

import io.xxnjdg.notp.user.object.data.transfer.SendCodeDTO;
import io.xxnjdg.notp.user.object.persistent.SendSmsLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户发送短信日志 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface SendSmsLogService extends IService<SendSmsLog> {

    /**
     * 发送验证码
     * @param sendCodeDTO sendCodeDTO
     */
    void postSendCode(SendCodeDTO sendCodeDTO);
}
