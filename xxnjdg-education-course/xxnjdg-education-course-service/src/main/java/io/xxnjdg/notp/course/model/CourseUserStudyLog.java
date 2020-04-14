package io.xxnjdg.notp.course.model;

import java.io.Serializable;
import java.util.Date;

public class CourseUserStudyLog implements Serializable {
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
     * 课程编号
     *
     * @mbg.generated
     */
    private Long courseId;

    /**
     * 课程名称
     *
     * @mbg.generated
     */
    private String courseName;

    /**
     * 章节编号
     *
     * @mbg.generated
     */
    private Long chapterId;

    /**
     * 章节名称
     *
     * @mbg.generated
     */
    private String chapterName;

    /**
     * 课时编号
     *
     * @mbg.generated
     */
    private Long periodId;

    /**
     * 课时名称
     *
     * @mbg.generated
     */
    private String periodName;

    /**
     * 用户编号
     *
     * @mbg.generated
     */
    private Long userNo;

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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", courseId=").append(courseId);
        sb.append(", courseName=").append(courseName);
        sb.append(", chapterId=").append(chapterId);
        sb.append(", chapterName=").append(chapterName);
        sb.append(", periodId=").append(periodId);
        sb.append(", periodName=").append(periodName);
        sb.append(", userNo=").append(userNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}