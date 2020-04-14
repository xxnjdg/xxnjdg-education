package io.xxnjdg.notp.course.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CourseAudit implements Serializable {
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
    private Integer auditStatus;

    /**
     * 审核意见
     *
     * @mbg.generated
     */
    private String auditOpinion;

    /**
     * 讲师用户编码
     *
     * @mbg.generated
     */
    private Long lecturerUserNo;

    /**
     * 一级分类ID
     *
     * @mbg.generated
     */
    private Long categoryId1;

    /**
     * 二级分类ID
     *
     * @mbg.generated
     */
    private Long categoryId2;

    /**
     * 三级分类ID
     *
     * @mbg.generated
     */
    private Long categoryId3;

    /**
     * 课程名称
     *
     * @mbg.generated
     */
    private String courseName;

    /**
     * 课程封面
     *
     * @mbg.generated
     */
    private String courseLogo;

    /**
     * 课程介绍ID
     *
     * @mbg.generated
     */
    private Long introduceId;

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
    private BigDecimal courseOriginal;

    /**
     * 优惠价
     *
     * @mbg.generated
     */
    private BigDecimal courseDiscount;

    /**
     * 是否上架(1:上架，0:下架)
     *
     * @mbg.generated
     */
    private Byte isPutaway;

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

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public Long getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Long categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Long getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Long categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Long getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Long categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLogo() {
        return courseLogo;
    }

    public void setCourseLogo(String courseLogo) {
        this.courseLogo = courseLogo;
    }

    public Long getIntroduceId() {
        return introduceId;
    }

    public void setIntroduceId(Long introduceId) {
        this.introduceId = introduceId;
    }

    public Byte getIsFree() {
        return isFree;
    }

    public void setIsFree(Byte isFree) {
        this.isFree = isFree;
    }

    public BigDecimal getCourseOriginal() {
        return courseOriginal;
    }

    public void setCourseOriginal(BigDecimal courseOriginal) {
        this.courseOriginal = courseOriginal;
    }

    public BigDecimal getCourseDiscount() {
        return courseDiscount;
    }

    public void setCourseDiscount(BigDecimal courseDiscount) {
        this.courseDiscount = courseDiscount;
    }

    public Byte getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Byte isPutaway) {
        this.isPutaway = isPutaway;
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
        sb.append(", categoryId1=").append(categoryId1);
        sb.append(", categoryId2=").append(categoryId2);
        sb.append(", categoryId3=").append(categoryId3);
        sb.append(", courseName=").append(courseName);
        sb.append(", courseLogo=").append(courseLogo);
        sb.append(", introduceId=").append(introduceId);
        sb.append(", isFree=").append(isFree);
        sb.append(", courseOriginal=").append(courseOriginal);
        sb.append(", courseDiscount=").append(courseDiscount);
        sb.append(", isPutaway=").append(isPutaway);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}