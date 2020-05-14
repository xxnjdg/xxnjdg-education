package io.xxnjdg.notp.user.object.data.transfer;

import io.xxnjdg.notp.utils.validator.annotations.IdentityUserPhoneAndEmail;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-20 上午1:53
 */
@Data
public class UserLoginPasswordDTO implements Serializable {

    private static final long serialVersionUID = 3240318938500500995L;
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
     * clientId
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String clientId;

    private String ip;

    @Null
    private Boolean admin;

}
