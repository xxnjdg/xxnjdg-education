package io.xxnjdg.notp.course.object.business;

import io.xxnjdg.notp.course.object.view.CourseChapterPeriodVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午7:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseChapterBO implements Serializable {

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
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 章节名称
     */
    private String chapterName;

    /**
     * 章节描述
     */
    private String chapterDesc;

    /**
     * 是否免费：1免费，0收费
     */
    private Integer isFree;

    /**
     * 原价
     */
    private BigDecimal chapterOriginal;

    /**
     * 优惠价
     */
    private BigDecimal chapterDiscount;

    /**
     * 课时信息
     */
    List<CourseChapterPeriodBO> courseChapterPeriodVOS;

}