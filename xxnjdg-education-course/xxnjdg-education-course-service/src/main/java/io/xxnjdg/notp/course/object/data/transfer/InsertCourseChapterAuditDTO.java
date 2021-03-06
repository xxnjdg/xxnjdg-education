package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.Update;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-10 下午7:18
 */
@Data
@Accessors(chain = true)
public class InsertCourseChapterAuditDTO implements Serializable {

    private static final long serialVersionUID = 5184099336382170939L;

    /**
     * 章节编号
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class})
    @Pattern(regexp = "^[\\d]{1,20}$",message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    private String id;

    /**
     * 排序
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Pattern(regexp = "^[1-254]$",message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    private String sort;
    /**
     * 课程编号
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Pattern(regexp = "^[\\d]{1,20}$",message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    private String courseId;
    /**
     * 章节名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String chapterName;
    /**
     * 是否免费：1免费，0收费
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[0-1]$",message = ValidationMessage.PARAMETER_ERROR)
    private String isFree;
    /**
     * 用户编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long userNo;

}
