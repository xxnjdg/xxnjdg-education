package io.xxnjdg.notp.system.objects.view;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-25 下午11:20
 */
@Data
@Accessors(chain = true)
public class SysVO implements Serializable {
    private static final long serialVersionUID = -2851636456262216282L;

    /**
     * 主键
     */
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
     * 支付通道（1龙果支付，2其他）
     */
    private Integer payType;
    /**
     * roncoo_key
     */
    private String roncooKey;
    /**
     * roncoo_secret
     */
    private String roncooSecret;
    /**
     * oss_url
     */
    private String aliyunOssUrl;
    /**
     * oss_bucket
     */
    private String aliyunOssBucket;
    /**
     * pay_url
     */
    private String payUrl;
    /**
     * pay_key
     */
    private String payKey;
    /**
     * pay_secret
     */
    private String paySecret;
    /**
     * notifu_url
     */
    private String notifyUrl;
    /**
     * smsCode
     */
    private String smsCode;
    /**
     * signName
     */
    private String signName;
}
