package io.xxnjdg.notp.user.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-9 下午7:30
 */
@Data
@Accessors(chain = true)
public class UpdateLecturerDTO implements Serializable {
    private static final long serialVersionUID = -3059351018635102514L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 讲师用户编号
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[\\d]{1,20}$")
    private String lecturerUserNo;
    /**
     * 讲师名称
     */
    @Size(max = 49,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String lecturerName;
    /**
     * 头像
     */
    @Size(max = 245,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String headImgUrl;
    /**
     * 简介
     */
    @Size(max = 2045,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String introduce;
}
