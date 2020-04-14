package io.xxnjdg.notp.course.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CourseChapterAudit implements Serializable {
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
     * 审核状态(0:待审核;1:审核通过;2:审核不通过)
     *
     * @mbg.generated
     */
    private Integer auditStatus;

    /**
     * 审核意见
     *
     * @mbg.generated
     */
    private String auditOpinion;

    /**
     * 课程ID
     *
     * @mbg.generated
     */
    private Long courseId;

    /**
     * 章节名称
     *
     * @mbg.generated
     */
    private String chapterName;

    /**
     * 章节描述
     *
     * @mbg.generated
     */
    private String chapterDesc;

    /**
     * 是否免费：1免费，0收费
     *
     * @mbg.generated
     */
    private Byte isFree;

    /**
     * 原价
     *
     * @mbg.generated
     */
    private BigDecimal chapterOriginal;

    /**
     * 优惠价
     *
     * @mbg.generated
     */
    private BigDecimal chapterDiscount;

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

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public void setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
    }

    public Byte getIsFree() {
        return isFree;
    }

    public void setIsFree(Byte isFree) {
        this.isFree = isFree;
    }

    public BigDecimal getChapterOriginal() {
        return chapterOriginal;
    }

    public void setChapterOriginal(BigDecimal chapterOriginal) {
        this.chapterOriginal = chapterOriginal;
    }

    public BigDecimal getChapterDiscount() {
        return chapterDiscount;
    }

    public void setChapterDiscount(BigDecimal chapterDiscount) {
        this.chapterDiscount = chapterDiscount;
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
        sb.append(", courseId=").append(courseId);
        sb.append(", chapterName=").append(chapterName);
        sb.append(", chapterDesc=").append(chapterDesc);
        sb.append(", isFree=").append(isFree);
        sb.append(", chapterOriginal=").append(chapterOriginal);
        sb.append(", chapterDiscount=").append(chapterDiscount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}