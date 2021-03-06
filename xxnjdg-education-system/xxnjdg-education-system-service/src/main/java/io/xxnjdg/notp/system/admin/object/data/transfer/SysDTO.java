package io.xxnjdg.notp.system.admin.object.data.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 21:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysDTO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 状态(1有效, 0无效)
     */
    private Integer statusId;

    /**
     * 排序
     */
    private Integer sort;

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
     * oss_url
     */
    private String aliyunOssUrl;

    /**
     * oss_bucket
     */
    private String aliyunOssBucket;

    /**
     * oas_vault
     */
    private String aliyunOasVault;

    /**
     * 支付通道（1龙果支付，2其他）
     */
    private Integer payType;

    /**
     * 支付请求
     */
    private String payUrl;

    /**
     * roncoo_key
     */
    private String payKey;

    /**
     * roncoo_secret
     */
    private String paySecret;

    /**
     * 回调地址
     */
    private String notifyUrl;

    /**
     * sms_code
     */
    private String smsCode;

    /**
     * 短信签名
     */
    private String signName;


}