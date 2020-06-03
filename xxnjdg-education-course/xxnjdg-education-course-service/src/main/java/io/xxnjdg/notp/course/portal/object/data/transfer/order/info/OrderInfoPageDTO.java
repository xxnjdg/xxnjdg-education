package io.xxnjdg.notp.course.portal.object.data.transfer.order.info;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 20:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfoPageDTO implements Serializable {
    private static final long serialVersionUID=1L;

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


    /**
     * 订单状态1待支付，2成功支付，3支付失败，4已关闭
     */
    @Range(max = 5,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Integer orderStatus;

    /**
     * 讲师编号
     */
    private Long lecturerUserNo;

    /**
     * 用户编号
     */
    @Null(message = ValidationMessage.PARAMETER_CANNOT_HAVE_VALUE)
    private Long userNo;
}
