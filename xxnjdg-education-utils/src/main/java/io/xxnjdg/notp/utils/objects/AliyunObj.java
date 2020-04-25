package io.xxnjdg.notp.utils.objects;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-25 下午9:10
 */
@Data
@Accessors(chain = true)
public class AliyunObj implements Serializable {
    private static final long serialVersionUID = -1041866079209312556L;

    private String polyvUseid;
    private String polyvWritetoken;
    private String polyvReadtoken;
    private String polyvSecretkey;
    /**
     * AccessKeyId
     */
    private String aliyunAccessKeyId;
    /**
     * AccessKeySecret
     */
    private String aliyunAccessKeySecret;
    private String aliyunOssUrl;
    private String aliyunOssBucket;
    private String aliyunOasVault;
    private String payUrl;
    private String payKey;
    private String paySecret;
    private String notifyUrl;
    /**
     * 短信模板
     */
    private String smsCode;
    /**
     * 短信签名
     */
    private String signName;
}
