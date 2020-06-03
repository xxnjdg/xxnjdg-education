package io.xxnjdg.notp.course.portal.object.view.course.audit;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 1:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseAuditSaveVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 课程ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
}
