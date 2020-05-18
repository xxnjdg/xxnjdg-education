package io.xxnjdg.notp.system.admin.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 21:22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysListVO {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 视频存储平台（1保利威视，2七牛）
     */
    private Integer videoType;
    /**
     * useid
     */
    private String polyvUseid;
    /**
     * writetoken
     */
    private String polyvWritetoken;
    /**
     * readtoken
     */
    private String polyvReadtoken;
    /**
     * secretkey
     */
    private String polyvSecretkey;
    /**
     * 文件存储类型（1阿里云，2七牛）
     */
    private Integer fileType;
    /**
     * access_key_id
     */
    private String aliyunAccessKeyId;
    /**
     * access_key_secret
     */
    private String aliyunAccessKeySecret;
    /**
     * aliyunOssUrl
     */
    private String aliyunOssUrl;
    /**
     * aliyunOssBucket
     */
    private String aliyunOssBucket;
    /**
     * smsCode
     */
    private String smsCode;
    /**
     * 短信签名
     */
    private String signName;
    /**
     * 支付通道（1龙果支付，2其他）
     */
    private Integer payType;
    /**
     * roncooKey
     */
    private String payKey;
    /**
     * roncooSecret
     */
    private String paySecret;
    /**
     * 支付请求
     */
    private String payUrl;
    /**
     * 回调地址
     */
    private String notifyUrl;
}
