package io.xxnjdg.notp.course.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CourseChapterPeriod implements Serializable {
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
     * 课程ID
     *
     * @mbg.generated
     */
    private Long courseId;

    /**
     * 章节ID
     *
     * @mbg.generated
     */
    private Long chapterId;

    /**
     * 课时名称
     *
     * @mbg.generated
     */
    private String periodName;

    /**
     * 课时描述
     *
     * @mbg.generated
     */
    private String periodDesc;

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
    private BigDecimal periodOriginal;

    /**
     * 优惠价
     *
     * @mbg.generated
     */
    private BigDecimal periodDiscount;

    /**
     * 购买人数
     *
     * @mbg.generated
     */
    private Integer countBuy;

    /**
     * 学习人数
     *
     * @mbg.generated
     */
    private Integer countStudy;

    /**
     * 是否存在文档(1存在，0否)
     *
     * @mbg.generated
     */
    private Byte isDoc;

    /**
     * 文档名称
     *
     * @mbg.generated
     */
    private String docName;

    /**
     * 文档地址
     *
     * @mbg.generated
     */
    private String docUrl;

    /**
     * 是否存在视频(1存在，0否)
     *
     * @mbg.generated
     */
    private String isVideo;

    /**
     * 视频编号
     *
     * @mbg.generated
     */
    private Long videoNo;

    /**
     * 视频名称
     *
     * @mbg.generated
     */
    private String videoName;

    /**
     * 时长
     *
     * @mbg.generated
     */
    private String videoLength;

    /**
     * 视频VID
     *
     * @mbg.generated
     */
    private String videoVid;

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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getPeriodDesc() {
        return periodDesc;
    }

    public void setPeriodDesc(String periodDesc) {
        this.periodDesc = periodDesc;
    }

    public Byte getIsFree() {
        return isFree;
    }

    public void setIsFree(Byte isFree) {
        this.isFree = isFree;
    }

    public BigDecimal getPeriodOriginal() {
        return periodOriginal;
    }

    public void setPeriodOriginal(BigDecimal periodOriginal) {
        this.periodOriginal = periodOriginal;
    }

    public BigDecimal getPeriodDiscount() {
        return periodDiscount;
    }

    public void setPeriodDiscount(BigDecimal periodDiscount) {
        this.periodDiscount = periodDiscount;
    }

    public Integer getCountBuy() {
        return countBuy;
    }

    public void setCountBuy(Integer countBuy) {
        this.countBuy = countBuy;
    }

    public Integer getCountStudy() {
        return countStudy;
    }

    public void setCountStudy(Integer countStudy) {
        this.countStudy = countStudy;
    }

    public Byte getIsDoc() {
        return isDoc;
    }

    public void setIsDoc(Byte isDoc) {
        this.isDoc = isDoc;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public String getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(String isVideo) {
        this.isVideo = isVideo;
    }

    public Long getVideoNo() {
        return videoNo;
    }

    public void setVideoNo(Long videoNo) {
        this.videoNo = videoNo;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(String videoLength) {
        this.videoLength = videoLength;
    }

    public String getVideoVid() {
        return videoVid;
    }

    public void setVideoVid(String videoVid) {
        this.videoVid = videoVid;
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
        sb.append(", courseId=").append(courseId);
        sb.append(", chapterId=").append(chapterId);
        sb.append(", periodName=").append(periodName);
        sb.append(", periodDesc=").append(periodDesc);
        sb.append(", isFree=").append(isFree);
        sb.append(", periodOriginal=").append(periodOriginal);
        sb.append(", periodDiscount=").append(periodDiscount);
        sb.append(", countBuy=").append(countBuy);
        sb.append(", countStudy=").append(countStudy);
        sb.append(", isDoc=").append(isDoc);
        sb.append(", docName=").append(docName);
        sb.append(", docUrl=").append(docUrl);
        sb.append(", isVideo=").append(isVideo);
        sb.append(", videoNo=").append(videoNo);
        sb.append(", videoName=").append(videoName);
        sb.append(", videoLength=").append(videoLength);
        sb.append(", videoVid=").append(videoVid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}