package io.xxnjdg.notp.system.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 20:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysEnumDTO implements Serializable {
    private static final long serialVersionUID = 5299822948285717245L;
    /**
     * 枚举名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_ERROR)
    private String enumName;
}
