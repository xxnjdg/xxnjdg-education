package io.xxnjdg.notp.system.model;

import java.io.Serializable;
import java.util.Date;

public class Website implements Serializable {
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
     * org_logo_ico
     *
     * @mbg.generated
     */
    private String logoIco;

    /**
     * org_logo_img
     *
     * @mbg.generated
     */
    private String logoImg;

    /**
     * 站点标题
     *
     * @mbg.generated
     */
    private String websiteTitle;

    /**
     * 站点关键词
     *
     * @mbg.generated
     */
    private String websiteKeyword;

    /**
     * 站点描述
     *
     * @mbg.generated
     */
    private String websiteDesc;

    /**
     * 站点版权
     *
     * @mbg.generated
     */
    private String copyright;

    /**
     * 备案号
     *
     * @mbg.generated
     */
    private String icp;

    /**
     * 公安备案号
     *
     * @mbg.generated
     */
    private String prn;

    /**
     * 站点微信
     *
     * @mbg.generated
     */
    private String weixin;

    /**
     * 小程序二维码
     *
     * @mbg.generated
     */
    private String weixinXcx;

    /**
     * 站点微博
     *
     * @mbg.generated
     */
    private String weibo;

    /**
     * 是否开启统计
     *
     * @mbg.generated
     */
    private Byte isEnableStatistics;

    /**
     * 统计代码
     *
     * @mbg.generated
     */
    private String statisticsCode;

    /**
     * 是否显示客服信息
     *
     * @mbg.generated
     */
    private Byte isShowService;

    /**
     * 客服信息1
     *
     * @mbg.generated
     */
    private String service1;

    /**
     * 客服信息2
     *
     * @mbg.generated
     */
    private String service2;

    /**
     * 招募标题
     *
     * @mbg.generated
     */
    private String recruitTitle;

    /**
     * 用户协议
     *
     * @mbg.generated
     */
    private String userAgreement;

    /**
     * 招募信息
     *
     * @mbg.generated
     */
    private String recruitInfo;

    /**
     * 入驻协议
     *
     * @mbg.generated
     */
    private String entryAgreement;

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

    public String getLogoIco() {
        return logoIco;
    }

    public void setLogoIco(String logoIco) {
        this.logoIco = logoIco;
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    public String getWebsiteTitle() {
        return websiteTitle;
    }

    public void setWebsiteTitle(String websiteTitle) {
        this.websiteTitle = websiteTitle;
    }

    public String getWebsiteKeyword() {
        return websiteKeyword;
    }

    public void setWebsiteKeyword(String websiteKeyword) {
        this.websiteKeyword = websiteKeyword;
    }

    public String getWebsiteDesc() {
        return websiteDesc;
    }

    public void setWebsiteDesc(String websiteDesc) {
        this.websiteDesc = websiteDesc;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp;
    }

    public String getPrn() {
        return prn;
    }

    public void setPrn(String prn) {
        this.prn = prn;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getWeixinXcx() {
        return weixinXcx;
    }

    public void setWeixinXcx(String weixinXcx) {
        this.weixinXcx = weixinXcx;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public Byte getIsEnableStatistics() {
        return isEnableStatistics;
    }

    public void setIsEnableStatistics(Byte isEnableStatistics) {
        this.isEnableStatistics = isEnableStatistics;
    }

    public String getStatisticsCode() {
        return statisticsCode;
    }

    public void setStatisticsCode(String statisticsCode) {
        this.statisticsCode = statisticsCode;
    }

    public Byte getIsShowService() {
        return isShowService;
    }

    public void setIsShowService(Byte isShowService) {
        this.isShowService = isShowService;
    }

    public String getService1() {
        return service1;
    }

    public void setService1(String service1) {
        this.service1 = service1;
    }

    public String getService2() {
        return service2;
    }

    public void setService2(String service2) {
        this.service2 = service2;
    }

    public String getRecruitTitle() {
        return recruitTitle;
    }

    public void setRecruitTitle(String recruitTitle) {
        this.recruitTitle = recruitTitle;
    }

    public String getUserAgreement() {
        return userAgreement;
    }

    public void setUserAgreement(String userAgreement) {
        this.userAgreement = userAgreement;
    }

    public String getRecruitInfo() {
        return recruitInfo;
    }

    public void setRecruitInfo(String recruitInfo) {
        this.recruitInfo = recruitInfo;
    }

    public String getEntryAgreement() {
        return entryAgreement;
    }

    public void setEntryAgreement(String entryAgreement) {
        this.entryAgreement = entryAgreement;
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
        sb.append(", logoIco=").append(logoIco);
        sb.append(", logoImg=").append(logoImg);
        sb.append(", websiteTitle=").append(websiteTitle);
        sb.append(", websiteKeyword=").append(websiteKeyword);
        sb.append(", websiteDesc=").append(websiteDesc);
        sb.append(", copyright=").append(copyright);
        sb.append(", icp=").append(icp);
        sb.append(", prn=").append(prn);
        sb.append(", weixin=").append(weixin);
        sb.append(", weixinXcx=").append(weixinXcx);
        sb.append(", weibo=").append(weibo);
        sb.append(", isEnableStatistics=").append(isEnableStatistics);
        sb.append(", statisticsCode=").append(statisticsCode);
        sb.append(", isShowService=").append(isShowService);
        sb.append(", service1=").append(service1);
        sb.append(", service2=").append(service2);
        sb.append(", recruitTitle=").append(recruitTitle);
        sb.append(", userAgreement=").append(userAgreement);
        sb.append(", recruitInfo=").append(recruitInfo);
        sb.append(", entryAgreement=").append(entryAgreement);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}