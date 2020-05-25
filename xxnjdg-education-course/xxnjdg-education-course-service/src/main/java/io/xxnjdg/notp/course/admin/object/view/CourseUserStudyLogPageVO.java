package io.xxnjdg.notp.course.admin.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 4:33
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseUserStudyLogPageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 课程ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    /**
     * 章节ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chapterId;
    /**
     * 课时ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long periodId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 章节名称
     */
    private String chapterName;
    /**
     * 课时名称
     */
    private String periodName;
}
