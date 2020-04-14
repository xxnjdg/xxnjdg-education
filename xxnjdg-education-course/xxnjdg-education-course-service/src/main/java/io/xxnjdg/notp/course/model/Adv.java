package io.xxnjdg.notp.course.model;

import java.io.Serializable;
import java.util.Date;

public class Adv implements Serializable {
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
     * 状态(1:正常，0:禁用)
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
     * 广告标题
     *
     * @mbg.generated
     */
    private String advTitle;

    /**
     * 广告图片
     *
     * @mbg.generated
     */
    private String advImg;

    /**
     * 广告链接
     *
     * @mbg.generated
     */
    private String advUrl;

    /**
     * 广告跳转方式
     *
     * @mbg.generated
     */
    private String advTarget;

    /**
     * 广告位置(1首页轮播)
     *
     * @mbg.generated
     */
    private Byte advLocation;

    /**
     * 开始时间
     *
     * @mbg.generated
     */
    private Date beginTime;

    /**
     * 结束时间
     *
     * @mbg.generated
     */
    private Date endTime;

    /**
     * 位置(0电脑端，1微信端)
     *
     * @mbg.generated
     */
    private Byte platShow;

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

    public String getAdvTitle() {
        return advTitle;
    }

    public void setAdvTitle(String advTitle) {
        this.advTitle = advTitle;
    }

    public String getAdvImg() {
        return advImg;
    }

    public void setAdvImg(String advImg) {
        this.advImg = advImg;
    }

    public String getAdvUrl() {
        return advUrl;
    }

    public void setAdvUrl(String advUrl) {
        this.advUrl = advUrl;
    }

    public String getAdvTarget() {
        return advTarget;
    }

    public void setAdvTarget(String advTarget) {
        this.advTarget = advTarget;
    }

    public Byte getAdvLocation() {
        return advLocation;
    }

    public void setAdvLocation(Byte advLocation) {
        this.advLocation = advLocation;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getPlatShow() {
        return platShow;
    }

    public void setPlatShow(Byte platShow) {
        this.platShow = platShow;
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
        sb.append(", advTitle=").append(advTitle);
        sb.append(", advImg=").append(advImg);
        sb.append(", advUrl=").append(advUrl);
        sb.append(", advTarget=").append(advTarget);
        sb.append(", advLocation=").append(advLocation);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", platShow=").append(platShow);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}