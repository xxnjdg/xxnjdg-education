package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-27 下午5:11
 */
@Data
public class OrderInfoListVO implements Serializable {
    private static final long serialVersionUID = -5176452964857830001L;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    /**
     * 用户编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userNo;
    /**
     * 订单号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderNo;
    /**
     * 课程id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    /**
     * 课程封面
     */
    private String courseLogo;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 实付金额
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal pricePaid;
    /**
     * 支付方式：1微信支付，2支付宝支付，3积分支付
     */
    private Integer payType;
    /**
     * 订单状态：1待支付，2成功支付，3支付失败，4已关闭，5已退款, 6订单解绑
     */
    private Integer orderStatus;
}
