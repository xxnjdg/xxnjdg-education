package io.xxnjdg.notp.course.object.business;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午5:08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseIntroduceBO implements Serializable {
    private static final long serialVersionUID = -5923121482956865011L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 课程简介
     */
    private String introduce;
}
