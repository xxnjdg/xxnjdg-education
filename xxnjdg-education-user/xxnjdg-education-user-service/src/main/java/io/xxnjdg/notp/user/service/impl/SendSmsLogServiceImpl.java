package io.xxnjdg.notp.user.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.apis.SysControllerApi;
import io.xxnjdg.notp.system.convert.SysVoToAliyunObj;
import io.xxnjdg.notp.system.objects.error.SysEnum;
import io.xxnjdg.notp.system.objects.view.SysVO;
import io.xxnjdg.notp.user.config.SnowFlakeId;
import io.xxnjdg.notp.user.object.data.transfer.SendCodeDTO;
import io.xxnjdg.notp.user.object.error.PlatformEnum;
import io.xxnjdg.notp.user.object.error.SendSmsLogEnum;
import io.xxnjdg.notp.user.object.persistent.Platform;
import io.xxnjdg.notp.user.object.persistent.SendSmsLog;
import io.xxnjdg.notp.user.mapper.SendSmsLogMapper;
import io.xxnjdg.notp.user.service.PlatformService;
import io.xxnjdg.notp.user.service.SendSmsLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.RedisPrefixField;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.AliyunUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.AliyunObj;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public void postSendCode(SendCodeDTO sendCodeDTO) {

        platformService.getPlatformByClientId(sendCodeDTO.getClientId());

        //查询系统设置是否存在
        ResponseResult<SysVO> sysResult = sysControllerApi.getSysFirstOne();
        SysVO sysData = sysResult.getData();
        if (!ObjectUtil.equal(sysResult.getStatus(),HttpStatus.SUCCESS.getStatus()) || sysData == null ){
            throw new BaseException(SysEnum.SYS_ERROR);
        }

        //生成随即码
        String code = RandomUtil.randomNumbers(6);

        //vo -> aliyunObj
        AliyunObj aliyunObj = SysVoToAliyunObj.INSTANCE.convert(sysData);

        //生成id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        // 设置 sendSmsLog
        SendSmsLog sendSmsLog = new SendSmsLog();
        sendSmsLog.setId(id);
        sendSmsLog.setGmtCreate(LocalDateTime.now());
        sendSmsLog.setMobile(sendCodeDTO.getMobile());
        sendSmsLog.setSmsCode(code);
        sendSmsLog.setTemplate(aliyunObj.getSmsCode());

        //发送短信
        Boolean aBoolean = AliyunUtil.SendSms(sendCodeDTO.getMobile(), code, aliyunObj);
        //success
        if (aBoolean){
            //设置状态 1 成功
            sendSmsLog.setIsSuccess(1);
            //设置验证码到 redis
            stringRedisTemplate.opsForValue().set(RedisPrefixField.VERIFY_PREFIX+sendCodeDTO.getMobile(),code,5, TimeUnit.MINUTES);
            //插入表
            if(!this.save(sendSmsLog)){
                throw new BaseException(SendSmsLogEnum.SEND_SMS_ERROR);
            }
        }else {
            //失败
            //设置状态 0 失败
            sendSmsLog.setIsSuccess(0);

            //插入表
            if(!this.save(sendSmsLog)){
                throw new BaseException(SendSmsLogEnum.SEND_SMS_ERROR);
            }

            throw new BaseException(SendSmsLogEnum.SEND_SMS_ERROR);
        }

    }
}
