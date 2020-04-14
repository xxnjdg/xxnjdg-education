package io.xxnjdg.notp.course.model;

import java.io.Serializable;
import java.util.Date;

public class OrderPay implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     * 订单号
     *
     * @mbg.generated
     */
    private Long orderNo;

    /**
     * 流水号
     *
     * @mbg.generated
     */
    private Long serialNumber;

    /**
     * 订单状态：1待支付，2成功支付，3支付失败，4已关闭，5已退款, 6订单解绑
     *
     * @mbg.generated
     */
    private Byte orderStatus;

    /**
     * 支付方式：1微信支付，2支付宝支付，3积分支付，4手工录单
     *
     * @mbg.generated
     */
    private Byte payType;

    /**
     * 支付时间
     *
     * @mbg.generated
     */
    private Date payTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", payType=").append(payType);
        sb.append(", payTime=").append(payTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}