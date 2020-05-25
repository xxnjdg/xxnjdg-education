package io.xxnjdg.notp.course.admin.object.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 4:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseUserStudyLogBO implements Serializable {

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
     * 课程编号
     */
    private Long courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 章节编号
     */
    private Long chapterId;

    /**
     * 章节名称
     */
    private String chapterName;

    /**
     * 课时编号
     */
    private Long periodId;

    /**
     * 课时名称
     */
    private String periodName;

    /**
     * 用户编号
     */
    private Long userNo;


}
