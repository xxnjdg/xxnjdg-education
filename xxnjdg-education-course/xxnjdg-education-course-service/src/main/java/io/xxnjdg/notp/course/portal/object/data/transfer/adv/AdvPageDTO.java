package io.xxnjdg.notp.course.portal.object.data.transfer.adv;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/28 21:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdvPageDTO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 位置(0电脑端，1微信端)
     */
    @Range(max=1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    private Integer platShow;
}
