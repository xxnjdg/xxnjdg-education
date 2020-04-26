package io.xxnjdg.notp.user.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.annotations.IdentityUserPhoneAndEmail;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-26 下午5:07
 */
@Data
@Accessors(chain = true)
public class UserRegisterDTO implements Serializable {
    private static final long serialVersionUID = -1947240493302109169L;

    /**
     * 手机号码
     */
    @IdentityUserPhoneAndEmail()
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String mobile;
    /**
     * 登录密码
     */
    @Pattern(regexp = "^[A-Za-z\\d$@!%*?&.]{6,20}$",message = ValidationMessage.PARAMETER_ERROR)
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String password;
    /**
     * 重复密码
     */
    @Pattern(regexp = "^[A-Za-z\\d$@!%*?&.]{6,20}$",message = ValidationMessage.PARAMETER_ERROR)
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String repassword;
    /**
     * clientId
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String clientId;
    /**
     * 手机验证码
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String code;

    private String ip;
}
