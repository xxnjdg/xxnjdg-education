package io.xxnjdg.notp.course.object.persistent;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程用户学习日志
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseUserStudyLog implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
