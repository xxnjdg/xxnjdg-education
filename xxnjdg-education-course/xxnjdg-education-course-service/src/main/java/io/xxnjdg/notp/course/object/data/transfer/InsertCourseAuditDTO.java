package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Update;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-10 上午9:50
 */
@Data
@Accessors(chain = true)
public class InsertCourseAuditDTO implements Serializable {

    private static final long serialVersionUID = -1375075427856832536L;

    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class})
    @Pattern(regexp = "^[\\d]{1,20}$",groups = {Update.class})
    private String id;

    /**
     * 一级分类ID
     */
    @Pattern(regexp = "^[\\d]{1,20}$",message = ValidationMessage.PARAMETER_ERROR)
    private String categoryId1;
    /**
     * 二级分类ID
     */
    @Pattern(regexp = "^[\\d]{1,20}$",message = ValidationMessage.PARAMETER_ERROR)
    private String categoryId2;
    /**
     * 三级分类ID
     */
    @Pattern(regexp = "^[\\d]{1,20}$",message = ValidationMessage.PARAMETER_ERROR)
    private String categoryId3;
    /**
     * 课程名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Size(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String courseName;
    /**
     * 课程封面
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Size(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String courseLogo;
    /**
     * 课程简介
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String introduce;
    /**
     * 原价
     */
    @Pattern(regexp = "^\\+?(?!0+(\\d|(\\.00?)?$))\\d+(\\.\\d\\d?)?$",message = ValidationMessage.PARAMETER_ERROR)
    @Size(max = 10,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String courseOriginal;
    /**
     * 用户编号
     */
    private Long lecturerUserNo;
    /**
     * 是否免费：1免费，0收费
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[0-1]$",message = ValidationMessage.PARAMETER_ERROR)
    private String isFree;
}