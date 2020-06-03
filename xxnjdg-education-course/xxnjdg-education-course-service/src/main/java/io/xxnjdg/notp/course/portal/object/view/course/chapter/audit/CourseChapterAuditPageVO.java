package io.xxnjdg.notp.course.portal.object.view.course.chapter.audit;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/30 0:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseChapterAuditPageVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 章节ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
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
     * 课时数量
     */
    private Integer periodNum;
}
