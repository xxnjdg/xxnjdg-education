package io.xxnjdg.notp.user.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.constant.IdentityUserPhoneAndEmailConstant;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-25 下午9:40
 */
@Data
public class SendCodeDTO implements Serializable {
    private static final long serialVersionUID = 5669969986286230653L;

    /**
     * 手机号码
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = IdentityUserPhoneAndEmailConstant.PHONE_REGEX)
    private String mobile;

    /**
     * clientId
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    private String clientId;
}
