package io.xxnjdg.notp.course.admin.object.business;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 17:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderPayBO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 订单号
     */
    private Long orderNo;

    /**
     * 流水号
     */
    private Long serialNumber;

    /**
     * 订单状态：1待支付，2成功支付，3支付失败，4已关闭，5已退款, 6订单解绑
     */
    private Integer orderStatus;

    /**
     * 支付方式：1微信支付，2支付宝支付，3积分支付，4手工录单
     */
    private Integer payType;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;


}
