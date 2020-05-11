package io.xxnjdg.notp.course.object.business;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-9 下午8:59
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseAuditBO implements Serializable {
    private static final long serialVersionUID = 4240690143858393154L;
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
     * 审核状态(0:待审核,1:审核通过,2:审核不通过)
     */
    private Integer auditStatus;

    /**
     * 审核意见
     */
    private String auditOpinion;

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
     * 是否可删除（1:可删除，0:不可删除）
     */
    private Integer isDelete;

    /**
     * 课程介绍
     */
    private String introduce;
}
