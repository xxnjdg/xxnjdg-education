package io.xxnjdg.notp.course.admin.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 16:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfoPageVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 讲师用户编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lecturerUserNo;
    /**
     * 讲师名称
     */
    private String lecturerName;
    /**
     * 用户编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userNo;
    /**
     * 用户电话
     */
    private String mobile;
    /**
     * 用户注册时间
     */
    private LocalDateTime registerTime;
    /**
     * 订单号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderNo;
    /**
     * 课程ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 实付金额
     */
    private BigDecimal pricePaid;
    /**
     * 交易类型：1线上支付，2线下支付
     */
    private Integer tradeType;
    /**
     * 支付方式：1微信支付，2支付宝支付
     */
    private Integer payType;
    /**
     * 购买渠道：1:WEB
     */
    private Integer channelType;
    /**
     * 订单状态：0待支付，1成功支付，2支付失败，3已关闭，4已退款
     */
    private Integer orderStatus;
    /**
     * 客户备注
     */
    private String remarkCus;
    /**
     * 支付时间
     */
    private LocalDateTime payTime;
}
