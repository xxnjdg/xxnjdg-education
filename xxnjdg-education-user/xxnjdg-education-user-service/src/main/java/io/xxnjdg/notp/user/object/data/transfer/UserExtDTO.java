package io.xxnjdg.notp.user.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-24 下午5:40
 */
@Data
public class UserExtDTO implements Serializable {
    private static final long serialVersionUID = -3946782194392607715L;

    /**
     * 用户编号
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    private Long userNo;
}
