package io.xxnjdg.notp.course.portal.object.view.course.audit;

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
 * @date 2020/5/29 0:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseAuditViewVO implements Serializable {
    private static final long serialVersionUID = 1;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 一级分类ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId1;
    /**
     * 二级分类ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId2;
    /**
     * 三级分类ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId3;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程封面
     */
    private String courseLogo;
    /**
     * 课程介绍
     */
    private String introduce;
    /**
     * 原价
     */
    private BigDecimal courseOriginal;
    /**
     * 优惠价
     */
    private BigDecimal courseDiscount;
    /**
     * 是否免费(1:免费, 0:收费)
     */
    private Integer isFree;
}
