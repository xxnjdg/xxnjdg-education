package io.xxnjdg.notp.utils.custom.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import io.xxnjdg.notp.utils.objects.AliyunObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-25 下午8:44
 */
public class AliyunUtil {

    private static Logger logger = LoggerFactory.getLogger(AliyunUtil.class);

    public static Boolean SendSms(String mobile, String code, AliyunObj aliyunObj) {
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou", aliyunObj.getAliyunAccessKeyId(), aliyunObj.getAliyunAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", aliyunObj.getSignName());
        request.putQueryParameter("TemplateCode", aliyunObj.getSmsCode());
        request.putQueryParameter("TemplateParam", "{\"code\":\"${code}\"}".replace("${code}", code));
        try {
            CommonResponse response = client.getCommonResponse(request);
            String data = response.getData();
            if (StrUtil.isBlank(data)){
                return false;
            }
            logger.info("sms返回码 "+data);
            String ok = JSONUtil.parseObj(data).get("Code").toString();
            if (StrUtil.isBlank(ok)){
                return false;
            }
            logger.info(ok);
            return ObjectUtil.equal("OK", ok);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

}
