package io.xxnjdg.notp.course.object.persistent;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程信息-审核
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseAudit implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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


}
