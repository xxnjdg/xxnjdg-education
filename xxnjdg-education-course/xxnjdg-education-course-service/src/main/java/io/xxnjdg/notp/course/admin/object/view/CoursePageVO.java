package io.xxnjdg.notp.course.admin.object.view;

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
 * @date 2020/5/23 17:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CoursePageVO implements Serializable {
    private static final long serialVersionUID = 1L;

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
     * 排序
     */
    private Integer sort;
    /**
     * 讲师用户编码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lecturerUserNo;
    /**
     * 讲师名称
     */
    private String lecturerName;

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
     * 课程介绍ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long introduceId;
    /**
     * 是否免费：1免费，0收费
     */
    private Integer isFree;
    /**
     * 原价
     */
    private BigDecimal courseOriginal;
    /**
     * 优惠价
     */
    private BigDecimal courseDiscount;
    /**
     * 是否上架(1:上架，0:下架)
     */
    private Integer isPutaway;
    /**
     * 是否已添加专区课程(1:存在，0:不存在)
     */
    private Integer isAddZoneCourse;
}
