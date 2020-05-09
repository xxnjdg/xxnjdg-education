package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.xxnjdg.notp.user.object.view.LecturerVO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-28 下午1:06
 */
@Data
public class CourseDetailVO implements Serializable {
    private static final long serialVersionUID = -1436721106330584397L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 讲师用户编码
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
    private List<CourseChapterLevelVO> chapterList;


}
