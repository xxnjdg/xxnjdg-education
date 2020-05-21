package io.xxnjdg.notp.course.admin.object.business;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 14:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZoneCourseBO implements Serializable {

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
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 状态(1:正常;0:禁用)
     */
    private Integer statusId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 专区编号
     */
    private Long zoneId;

    /**
     * 位置(0电脑端，1微信端)
     */
    private Integer zoneLocation;

    /**
     * 课程ID
     */
    private Long courseId;


    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 一级分类名
     */
    private String categoryName1;
    /**
     * 二级分类名
     */
    private String categoryName2;
    /**
     * 三级分类名
     */
    private String categoryName3;
}
