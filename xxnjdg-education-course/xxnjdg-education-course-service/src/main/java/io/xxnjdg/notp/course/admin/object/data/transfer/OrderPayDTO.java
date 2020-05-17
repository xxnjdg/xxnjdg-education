package io.xxnjdg.notp.course.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 17:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderPayDTO implements Serializable {

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
     * 订单号
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long orderNo;

    /**
     * 主键
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long id;

    /**
     * 创建时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime gmtCreate;

    /**
     * 流水号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long serialNumber;

    /**
     * 订单状态：1待支付，2成功支付，3支付失败，4已关闭，5已退款, 6订单解绑
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer orderStatus;

    /**
     * 支付方式：1微信支付，2支付宝支付，3积分支付，4手工录单
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer payType;

    /**
     * 支付时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime payTime;


}