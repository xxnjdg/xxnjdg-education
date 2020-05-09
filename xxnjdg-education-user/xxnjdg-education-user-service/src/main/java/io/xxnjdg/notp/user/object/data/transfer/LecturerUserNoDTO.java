package io.xxnjdg.notp.user.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-29 上午3:52
 */
@Data
@Accessors(chain = true)
public class LecturerUserNoDTO implements Serializable {
    private static final long serialVersionUID = 8208571530829456110L;

    /**
     * 讲师用户编号
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[\\d]{1,20}$")
    private String lecturerUserNo;
}
