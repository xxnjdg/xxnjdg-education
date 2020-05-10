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
 * @date 20-5-9 下午9:03
 */
@Data
@Accessors(chain = true)
public class ListCourseAuditBTO implements Serializable {

    private static final long serialVersionUID = -6381676648077847197L;
    /**
     * 审核状态(0:待审核,1:审核通过,2:审核不通过)
     */
    @Pattern(regexp = "^[0-2]$",message = ValidationMessage.PARAMETER_ERROR)
    private String auditStatus;

    /**
     * 讲师编号
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[\\d]{1,20}$",message = ValidationMessage.PARAMETER_ERROR)
    private String lecturerUserNo;

    /**
     * 当前页
     */
    @Pattern(regexp = "^[1-9]\\d*$",message = ValidationMessage.PARAMETER_ERROR)
    private String pageCurrent;

    /**
     * 每页记录数
     */
    @Pattern(regexp = "(^[1][0-9]$)|(^[2][0]$)|(^[1-9]$)",message = ValidationMessage.PARAMETER_ERROR)
    private String pageSize;
}