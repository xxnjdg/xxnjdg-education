package io.xxnjdg.notp.course.admin.object.data.transfer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 16:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseDTO implements Serializable {

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
     * 讲师用户编码
     */
    private Long lecturerUserNo;

    /**
     * 一级分类ID
     */
    private Long categoryId1;

    /**
     * 二级分类ID
     */
    private Long categoryId2;

    /**
     * 三级分类ID
     */
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
     * 课程排序(前端显示使用)
     */
    private Integer courseSort;

    /**
     * 购买人数
     */
    private Integer countBuy;

    /**
     * 学习人数
     */
    private Integer countStudy;

    /**
     * 总课时数
     */
    private Integer periodTotal;


}
