package io.xxnjdg.notp.user.controller;


import io.xxnjdg.notp.user.object.data.transfer.SendCodeDTO;
import io.xxnjdg.notp.user.service.SendSmsLogService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户发送短信日志 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@RestController
public class SendSmsLogController {

    @Autowired
    private SendSmsLogService sendSmsLogService;

    @PostMapping("/user/api/user/send/code")
    public ResponseResult postSendCode(@RequestBody @Validated SendCodeDTO sendCodeDTO){
        sendSmsLogService.postSendCode(sendCodeDTO);
        return ResponseResult.success("成功");
    }

}

