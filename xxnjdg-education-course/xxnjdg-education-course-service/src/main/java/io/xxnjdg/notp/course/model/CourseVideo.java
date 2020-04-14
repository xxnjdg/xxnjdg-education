package io.xxnjdg.notp.course.model;

import java.io.Serializable;
import java.util.Date;

public class CourseVideo implements Serializable {
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
     * 课时ID
     *
     * @mbg.generated
     */
    private Long periodId;

    /**
     * 视频名称
     *
     * @mbg.generated
     */
    private String videoName;

    /**
     * 视频编号
     *
     * @mbg.generated
     */
    private Long videoNo;

    /**
     * 视频状态(1待上传，2上传成功，3上传失败)
     *
     * @mbg.generated
     */
    private Byte videoStatus;

    /**
     * 时长
     *
     * @mbg.generated
     */
    private String videoLength;

    /**
     * 视频ID
     *
     * @mbg.generated
     */
    private String videoVid;

    /**
     * 阿里云oas
     *
     * @mbg.generated
     */
    private String videoOasId;

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

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Long getVideoNo() {
        return videoNo;
    }

    public void setVideoNo(Long videoNo) {
        this.videoNo = videoNo;
    }

    public Byte getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(Byte videoStatus) {
        this.videoStatus = videoStatus;
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

    public String getVideoOasId() {
        return videoOasId;
    }

    public void setVideoOasId(String videoOasId) {
        this.videoOasId = videoOasId;
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
        sb.append(", periodId=").append(periodId);
        sb.append(", videoName=").append(videoName);
        sb.append(", videoNo=").append(videoNo);
        sb.append(", videoStatus=").append(videoStatus);
        sb.append(", videoLength=").append(videoLength);
        sb.append(", videoVid=").append(videoVid);
        sb.append(", videoOasId=").append(videoOasId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}