package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-19 下午4:32
 */
@Data
public class CourseListVO implements Serializable {

    private static final long serialVersionUID = 4633846467932225814L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

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
