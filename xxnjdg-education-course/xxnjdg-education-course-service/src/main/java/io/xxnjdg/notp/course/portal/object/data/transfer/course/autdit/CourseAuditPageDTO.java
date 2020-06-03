package io.xxnjdg.notp.course.portal.object.data.transfer.course.autdit;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/28 21:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseAuditPageDTO implements Serializable {
    private static final long serialVersionUID=1L;

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

    /**
     * 审核状态(0:待审核,1:审核通过,2:审核不通过)
     */
    @Range(max = 2,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Integer auditStatus;

    /**
     * 讲师用户编码
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    private Long lecturerUserNo;
}
