package io.xxnjdg.notp.course.portal.object.data.transfer.course.autdit;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.constant.RegexConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 1:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseAuditSaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 一级分类ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long categoryId1;
    /**
     * 二级分类ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long categoryId2;
    /**
     * 三级分类ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long categoryId3;
    /**
     * 课程名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String courseName;
    /**
     * 课程封面
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String courseLogo;
    /**
     * 课程简介
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String introduce;
    /**
     * 原价
     */
    @Pattern(regexp = RegexConstant.COURSE_PRICE,message = ValidationMessage.PARAMETER_ERROR)
    private String courseOriginal;
    /**
     * 讲师用户编码
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long lecturerUserNo;
    /**
     * 是否免费：1免费，0收费
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Integer isFree;
}
