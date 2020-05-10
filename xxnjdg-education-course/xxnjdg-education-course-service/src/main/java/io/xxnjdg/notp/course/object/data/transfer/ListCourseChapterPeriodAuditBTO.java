package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-10 下午5:20
 */
@Data
@Accessors(chain = true)
public class ListCourseChapterPeriodAuditBTO implements Serializable {

    private static final long serialVersionUID = 1176490440394984120L;
    /**
     * 课程ID
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[\\d]{1,20}$",message = ValidationMessage.PARAMETER_ERROR)
    private String chapterId;
}
