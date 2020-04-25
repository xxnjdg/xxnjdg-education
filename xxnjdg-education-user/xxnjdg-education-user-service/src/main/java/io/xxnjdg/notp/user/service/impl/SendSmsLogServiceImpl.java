package io.xxnjdg.notp.user.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.apis.SysControllerApi;
import io.xxnjdg.notp.system.convert.SysVoToAliyunObj;
import io.xxnjdg.notp.system.objects.error.SysEnum;
import io.xxnjdg.notp.system.objects.view.SysVO;
import io.xxnjdg.notp.user.object.data.transfer.SendCodeDTO;
import io.xxnjdg.notp.user.object.error.PlatformEnum;
import io.xxnjdg.notp.user.object.persistent.Platform;
import io.xxnjdg.notp.user.object.persistent.SendSmsLog;
import io.xxnjdg.notp.user.mapper.SendSmsLogMapper;
import io.xxnjdg.notp.user.service.PlatformService;
import io.xxnjdg.notp.user.service.SendSmsLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.AliyunUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.AliyunObj;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户发送短信日志 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Service
public class SendSmsLogServiceImpl extends ServiceImpl<SendSmsLogMapper, SendSmsLog> implements SendSmsLogService {

    @Autowired
    private PlatformService platformService;

    @Autowired
    private SysControllerApi sysControllerApi;

    @Override
    public void postSendCode(SendCodeDTO sendCodeDTO) {

        LambdaQueryWrapper<Platform> platformLambdaQueryWrapper = new QueryWrapper<Platform>().lambda()
                .eq(Platform::getClientId, sendCodeDTO.getClientId())
                .eq(Platform::getStatusId, RowStatus.ENABLE);

        Platform platform = platformService.getOne(platformLambdaQueryWrapper);
        if (platform == null){
            throw new BaseException(PlatformEnum.CLIENT_ID_ERROR);
        }

        ResponseResult<SysVO> sysResult = sysControllerApi.getSysFirstOne();
        SysVO sysData = sysResult.getData();
        if (!ObjectUtil.equal(sysResult.getStatus(),HttpStatus.SUCCESS.getStatus()) || sysData == null ){
            throw new BaseException(SysEnum.SYS_ERROR);
        }

        // 自定义纯数字的验证码（随机4位数字，可重复）
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 6);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        lineCaptcha.setGenerator(randomGenerator);
        // 重新生成code
        lineCaptcha.createCode();

        String code = lineCaptcha.getCode();

        AliyunObj aliyunObj = SysVoToAliyunObj.INSTANCE.convert(sysData);

        SendSmsLog sendSmsLog = new SendSmsLog();
        sendSmsLog.setGmtCreate(LocalDateTime.now());
        sendSmsLog.setMobile(sendCodeDTO.getMobile());
        sendSmsLog.setSmsCode(code);
        sendSmsLog.setTemplate(aliyunObj.getSmsCode());

        Boolean aBoolean = AliyunUtil.SendSms(sendCodeDTO.getMobile(), code, aliyunObj);
        if (aBoolean){
            //success
            sendSmsLog.setIsSuccess(1);

            if(!this.save(sendSmsLog)){
                throw new BaseException(SysEnum.SYS_ERROR);
            }
        }else {
            sendSmsLog.setIsSuccess(0);

            if(!this.save(sendSmsLog)){
                throw new BaseException(SysEnum.SYS_ERROR);
            }

            throw new BaseException(SysEnum.SYS_ERROR);
        }

    }
}
