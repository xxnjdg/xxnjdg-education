package io.xxnjdg.notp.system.model;

import java.io.Serializable;
import java.util.Date;

public class Sys implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     * 修改时间
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * 状态(1有效, 0无效)
     *
     * @mbg.generated
     */
    private Byte statusId;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * 视频存储平台（1保利威视，2七牛）
     *
     * @mbg.generated
     */
    private Byte videoType;

    /**
     * useid
     *
     * @mbg.generated
     */
    private String polyvUseid;

    /**
     * writetoken
     *
     * @mbg.generated
     */
    private String polyvWritetoken;

    /**
     * readtoken
     *
     * @mbg.generated
     */
    private String polyvReadtoken;

    /**
     * secretkey
     *
     * @mbg.generated
     */
    private String polyvSecretkey;

    /**
     * 文件存储类型（1阿里云，2七牛）
     *
     * @mbg.generated
     */
    private Byte fileType;

    /**
     * access_key_id
     *
     * @mbg.generated
     */
    private String aliyunAccessKeyId;

    /**
     * access_key_secret
     *
     * @mbg.generated
     */
    private String aliyunAccessKeySecret;

    /**
     * oss_url
     *
     * @mbg.generated
     */
    private String aliyunOssUrl;

    /**
     * oss_bucket
     *
     * @mbg.generated
     */
    private String aliyunOssBucket;

    /**
     * oas_vault
     *
     * @mbg.generated
     */
    private String aliyunOasVault;

    /**
     * 支付通道（1龙果支付，2其他）
     *
     * @mbg.generated
     */
    private Byte payType;

    /**
     * 支付请求
     *
     * @mbg.generated
     */
    private String payUrl;

    /**
     * roncoo_key
     *
     * @mbg.generated
     */
    private String payKey;

    /**
     * roncoo_secret
     *
     * @mbg.generated
     */
    private String paySecret;

    /**
     * 回调地址
     *
     * @mbg.generated
     */
    private String notifyUrl;

    /**
     * sms_code
     *
     * @mbg.generated
     */
    private String smsCode;

    /**
     * 短信签名
     *
     * @mbg.generated
     */
    private String signName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Byte getStatusId() {
        return statusId;
    }

    public void setStatusId(Byte statusId) {
        this.statusId = statusId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getVideoType() {
        return videoType;
    }

    public void setVideoType(Byte videoType) {
        this.videoType = videoType;
    }

    public String getPolyvUseid() {
        return polyvUseid;
    }

    public void setPolyvUseid(String polyvUseid) {
        this.polyvUseid = polyvUseid;
    }

    public String getPolyvWritetoken() {
        return polyvWritetoken;
    }

    public void setPolyvWritetoken(String polyvWritetoken) {
        this.polyvWritetoken = polyvWritetoken;
    }

    public String getPolyvReadtoken() {
        return polyvReadtoken;
    }

    public void setPolyvReadtoken(String polyvReadtoken) {
        this.polyvReadtoken = polyvReadtoken;
    }

    public String getPolyvSecretkey() {
        return polyvSecretkey;
    }

    public void setPolyvSecretkey(String polyvSecretkey) {
        this.polyvSecretkey = polyvSecretkey;
    }

    public Byte getFileType() {
        return fileType;
    }

    public void setFileType(Byte fileType) {
        this.fileType = fileType;
    }

    public String getAliyunAccessKeyId() {
        return aliyunAccessKeyId;
    }

    public void setAliyunAccessKeyId(String aliyunAccessKeyId) {
        this.aliyunAccessKeyId = aliyunAccessKeyId;
    }

    public String getAliyunAccessKeySecret() {
        return aliyunAccessKeySecret;
    }

    public void setAliyunAccessKeySecret(String aliyunAccessKeySecret) {
        this.aliyunAccessKeySecret = aliyunAccessKeySecret;
    }

    public String getAliyunOssUrl() {
        return aliyunOssUrl;
    }

    public void setAliyunOssUrl(String aliyunOssUrl) {
        this.aliyunOssUrl = aliyunOssUrl;
    }

    public String getAliyunOssBucket() {
        return aliyunOssBucket;
    }

    public void setAliyunOssBucket(String aliyunOssBucket) {
        this.aliyunOssBucket = aliyunOssBucket;
    }

    public String getAliyunOasVault() {
        return aliyunOasVault;
    }

    public void setAliyunOasVault(String aliyunOasVault) {
        this.aliyunOasVault = aliyunOasVault;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }

    public String getPaySecret() {
        return paySecret;
    }

    public void setPaySecret(String paySecret) {
        this.paySecret = paySecret;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", statusId=").append(statusId);
        sb.append(", sort=").append(sort);
        sb.append(", videoType=").append(videoType);
        sb.append(", polyvUseid=").append(polyvUseid);
        sb.append(", polyvWritetoken=").append(polyvWritetoken);
        sb.append(", polyvReadtoken=").append(polyvReadtoken);
        sb.append(", polyvSecretkey=").append(polyvSecretkey);
        sb.append(", fileType=").append(fileType);
        sb.append(", aliyunAccessKeyId=").append(aliyunAccessKeyId);
        sb.append(", aliyunAccessKeySecret=").append(aliyunAccessKeySecret);
        sb.append(", aliyunOssUrl=").append(aliyunOssUrl);
        sb.append(", aliyunOssBucket=").append(aliyunOssBucket);
        sb.append(", aliyunOasVault=").append(aliyunOasVault);
        sb.append(", payType=").append(payType);
        sb.append(", payUrl=").append(payUrl);
        sb.append(", payKey=").append(payKey);
        sb.append(", paySecret=").append(paySecret);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", smsCode=").append(smsCode);
        sb.append(", signName=").append(signName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}