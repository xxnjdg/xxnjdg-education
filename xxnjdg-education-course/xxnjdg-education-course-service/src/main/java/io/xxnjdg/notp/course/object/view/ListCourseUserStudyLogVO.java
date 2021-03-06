package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-9 下午6:04
 */
@Data
@Accessors(chain = true)
public class ListCourseUserStudyLogVO implements Serializable {
    private static final long serialVersionUID = -5970280479703674962L;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    /**
     * 课时编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long periodId;
    /**
     * 课时名称
     */
    private String periodName;
    /**
     * 课程编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    /**
     * 课程名称
     */
    private String courseName;
}
