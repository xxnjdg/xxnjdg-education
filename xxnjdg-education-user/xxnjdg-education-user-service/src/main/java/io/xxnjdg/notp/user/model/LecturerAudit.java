package io.xxnjdg.notp.user.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LecturerAudit implements Serializable {
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
     * 审核状态(0:待审核,1:审核通过,2:审核不通过)
     *
     * @mbg.generated
     */
    private Byte auditStatus;

    /**
     * 审核意见
     *
     * @mbg.generated
     */
    private String auditOpinion;

    /**
     * 讲师用户编号
     *
     * @mbg.generated
     */
    private Long lecturerUserNo;

    /**
     * 讲师名称
     *
     * @mbg.generated
     */
    private String lecturerName;

    /**
     * 讲师手机
     *
     * @mbg.generated
     */
    private String lecturerMobile;

    /**
     * 讲师邮箱
     *
     * @mbg.generated
     */
    private String lecturerEmail;

    /**
     * 职位
     *
     * @mbg.generated
     */
    private String position;

    /**
     * 头像
     *
     * @mbg.generated
     */
    private String headImgUrl;

    /**
     * 简介
     *
     * @mbg.generated
     */
    private String introduce;

    /**
     * 讲师分成比例
     *
     * @mbg.generated
     */
    private BigDecimal lecturerProportion;

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

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerMobile() {
        return lecturerMobile;
    }

    public void setLecturerMobile(String lecturerMobile) {
        this.lecturerMobile = lecturerMobile;
    }

    public String getLecturerEmail() {
        return lecturerEmail;
    }

    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public BigDecimal getLecturerProportion() {
        return lecturerProportion;
    }

    public void setLecturerProportion(BigDecimal lecturerProportion) {
        this.lecturerProportion = lecturerProportion;
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
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", auditOpinion=").append(auditOpinion);
        sb.append(", lecturerUserNo=").append(lecturerUserNo);
        sb.append(", lecturerName=").append(lecturerName);
        sb.append(", lecturerMobile=").append(lecturerMobile);
        sb.append(", lecturerEmail=").append(lecturerEmail);
        sb.append(", position=").append(position);
        sb.append(", headImgUrl=").append(headImgUrl);
        sb.append(", introduce=").append(introduce);
        sb.append(", lecturerProportion=").append(lecturerProportion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}