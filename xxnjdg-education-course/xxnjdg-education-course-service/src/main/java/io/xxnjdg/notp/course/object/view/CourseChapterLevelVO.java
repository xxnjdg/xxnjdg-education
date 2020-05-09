package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-28 下午2:57
 */
@Data
public class CourseChapterLevelVO implements Serializable {
    private static final long serialVersionUID = -8492169248359753922L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;
    /**
     * 课程ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
    List<CourseChapterPeriodVO> courseChapterPeriodVOS;
}
