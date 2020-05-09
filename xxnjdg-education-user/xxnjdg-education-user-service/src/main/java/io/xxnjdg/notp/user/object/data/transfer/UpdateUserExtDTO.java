package io.xxnjdg.notp.user.object.data.transfer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-9 上午5:13
 */
@Data
@Accessors(chain = true)
public class UpdateUserExtDTO implements Serializable {

    private static final long serialVersionUID = 928852368491333877L;
    /**
     * 用户no
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[\\d]{1,20}$")
    private String userNo;

    /**
     * 性别(1男，2女，3保密)
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[123]$")
    private String sex;
    /**
     * 年龄
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^((1[0-5])|[1-9])?\\d$")
    private String age;
    /**
     * 昵称
     */
    @Size(max = 50,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String nickname;
    /**
     * 头像地址
     */
    @Size(max = 255,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String headImgUrl;
}
