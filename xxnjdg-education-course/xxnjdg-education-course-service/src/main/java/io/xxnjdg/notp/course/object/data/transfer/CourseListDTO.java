package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.CourseIsFree;
import io.xxnjdg.notp.utils.constant.DefaultPageValue;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-19 下午4:20
 */
@Data
public class CourseListDTO implements Serializable {

    /**
     * 当前页
     */
    @Min(value = DefaultPageValue.MIN,message = ValidationMessage.PARAMETER_ERROR)
    private Integer pageCurrent;

    /**
     * 每页条数
     */
    @Min(value = DefaultPageValue.MIN,message = ValidationMessage.PARAMETER_ERROR)
    private Integer pageSize;

    /**
     * 一级分类编号
     */
    private Long categoryId1;

    /**
     * 二级分类编号
     */
    private Long categoryId2;

    /**
     * 三级分类编号
     */
    private Long categoryId3;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 是否免费(1:免费，0:收费)
     */
    @Range(min = CourseIsFree.CHARGES,max = CourseIsFree.FREE,message = ValidationMessage.PARAMETER_ERROR)
    private Integer isFree;

}
