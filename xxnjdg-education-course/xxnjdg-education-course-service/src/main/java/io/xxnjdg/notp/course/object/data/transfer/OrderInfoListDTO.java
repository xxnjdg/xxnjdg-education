package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.DefaultPageValue;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-27 下午4:55
 */
@Data
@Accessors(chain = true)
public class OrderInfoListDTO implements Serializable {
    private static final long serialVersionUID = -7297338159950007375L;

    /**
     * 订单状态1待支付，2成功支付，3支付失败，4已关闭
     */
    @Pattern(regexp = "^[0-5]$",message = ValidationMessage.PARAMETER_ERROR)
    private String orderStatus;

    /**
     * 讲师编号
     */
    private Long lecturerUserNo;

    /**
     * 用户编号
     */
    private Long userNo;

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
}
