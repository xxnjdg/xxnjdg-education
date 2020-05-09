package io.xxnjdg.notp.course.object.business;

import io.xxnjdg.notp.course.object.view.CourseChapterLevelVO;
import io.xxnjdg.notp.user.object.view.LecturerVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 上午4:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseDetailBO implements Serializable {
    private static final long serialVersionUID = -6915590827828766012L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 讲师用户编码
     */
    private Long lecturerUserNo;
    /**
     * 是否免费：1免费，0收费
     */
    private Integer isFree;
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
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程封面
     */
    private String courseLogo;
    /**
     * 课程原价
     */
    private BigDecimal courseOriginal;
    /**
     * 课程优惠价
     */
    private BigDecimal courseDiscount;
    /**
     * 课程介绍
     */
    private String introduce;

    /**
     * 讲师信息
     */
    private LecturerVO lecturer;
    /**
     * 是否购买
     */
    private Integer isPay;
    /**
     * 章节信息
     */
    private List<CourseChapterBO> chapterList;
}
