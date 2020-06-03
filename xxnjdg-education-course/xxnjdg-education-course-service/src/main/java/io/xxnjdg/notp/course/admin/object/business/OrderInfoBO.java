package io.xxnjdg.notp.course.admin.object.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 16:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfoBO implements Serializable {

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
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 讲师用户编号
     */
    private Long lecturerUserNo;

    /**
     * 讲师名称
     */
    private String lecturerName;

    /**
     * 用户编号
     */
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
    private Long orderNo;

    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 应付金额
     */
    private BigDecimal pricePayable;

    /**
     * 优惠金额
     */
    private BigDecimal priceDiscount;

    /**
     * 实付金额
     */
    private BigDecimal pricePaid;

    /**
     * 平台收入
     */
    private BigDecimal platformProfit;

    /**
     * 讲师收入
     */
    private BigDecimal lecturerProfit;

    /**
     * 交易类型：1线上支付，2线下支付
     */
    private Integer tradeType;

    /**
     * 支付方式：1微信支付，2支付宝支付
     */
    private Integer payType;

    /**
     * 购买渠道：1web
     */
    private Integer channelType;

    /**
     * 订单状态：1待支付，2成功支付，3支付失败，4已关闭
     */
    private Integer orderStatus;

    /**
     * 是否显示给讲师(1是，0否)
     */
    private Integer isShowLecturer;

    /**
     * 是否显示给用户看(1是，0否)
     */
    private Integer isShowUser;

    /**
     * 客户备注
     */
    private String remarkCus;

    /**
     * 后台备注
     */
    private String remark;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 流水号
     */
    private Long serialNumber;

}
