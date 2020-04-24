package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-18 下午6:31
 */
@Data
public class ZoneCourseVO implements Serializable {

    private static final long serialVersionUID = 2262135392938369752L;
    /**
     * 课程主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 讲师用户编码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lecturerUserNo;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程封面
     */
    private String courseLogo;
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

}
