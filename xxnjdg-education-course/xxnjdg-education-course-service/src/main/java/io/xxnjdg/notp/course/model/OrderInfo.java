package io.xxnjdg.notp.course.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo implements Serializable {
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
     * 修改时间
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * 讲师用户编号
     *
     * @mbg.generated
     */
    private Long lecturerUserNo;

    /**
     * 讲师名称
     *
     * @mbg.generated
     */
    private String lecturerName;

    /**
     * 用户编号
     *
     * @mbg.generated
     */
    private Long userNo;

    /**
     * 用户电话
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * 用户注册时间
     *
     * @mbg.generated
     */
    private Date registerTime;

    /**
     * 订单号
     *
     * @mbg.generated
     */
    private Long orderNo;

    /**
     * 课程ID
     *
     * @mbg.generated
     */
    private Long courseId;

    /**
     * 课程名称
     *
     * @mbg.generated
     */
    private String courseName;

    /**
     * 应付金额
     *
     * @mbg.generated
     */
    private BigDecimal pricePayable;

    /**
     * 优惠金额
     *
     * @mbg.generated
     */
    private BigDecimal priceDiscount;

    /**
     * 实付金额
     *
     * @mbg.generated
     */
    private BigDecimal pricePaid;

    /**
     * 平台收入
     *
     * @mbg.generated
     */
    private BigDecimal platformProfit;

    /**
     * 讲师收入
     *
     * @mbg.generated
     */
    private BigDecimal lecturerProfit;

    /**
     * 交易类型：1线上支付，2线下支付
     *
     * @mbg.generated
     */
    private Byte tradeType;

    /**
     * 支付方式：1微信支付，2支付宝支付
     *
     * @mbg.generated
     */
    private Byte payType;

    /**
     * 购买渠道：1web
     *
     * @mbg.generated
     */
    private Byte channelType;

    /**
     * 订单状态：1待支付，2成功支付，3支付失败，4已关闭
     *
     * @mbg.generated
     */
    private Byte orderStatus;

    /**
     * 是否显示给讲师(1是，0否)
     *
     * @mbg.generated
     */
    private Byte isShowLecturer;

    /**
     * 是否显示给用户看(1是，0否)
     *
     * @mbg.generated
     */
    private Byte isShowUser;

    /**
     * 客户备注
     *
     * @mbg.generated
     */
    private String remarkCus;

    /**
     * 后台备注
     *
     * @mbg.generated
     */
    private String remark;

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

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getPricePayable() {
        return pricePayable;
    }

    public void setPricePayable(BigDecimal pricePayable) {
        this.pricePayable = pricePayable;
    }

    public BigDecimal getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(BigDecimal priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public BigDecimal getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(BigDecimal pricePaid) {
        this.pricePaid = pricePaid;
    }

    public BigDecimal getPlatformProfit() {
        return platformProfit;
    }

    public void setPlatformProfit(BigDecimal platformProfit) {
        this.platformProfit = platformProfit;
    }

    public BigDecimal getLecturerProfit() {
        return lecturerProfit;
    }

    public void setLecturerProfit(BigDecimal lecturerProfit) {
        this.lecturerProfit = lecturerProfit;
    }

    public Byte getTradeType() {
        return tradeType;
    }

    public void setTradeType(Byte tradeType) {
        this.tradeType = tradeType;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Byte getChannelType() {
        return channelType;
    }

    public void setChannelType(Byte channelType) {
        this.channelType = channelType;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getIsShowLecturer() {
        return isShowLecturer;
    }

    public void setIsShowLecturer(Byte isShowLecturer) {
        this.isShowLecturer = isShowLecturer;
    }

    public Byte getIsShowUser() {
        return isShowUser;
    }

    public void setIsShowUser(Byte isShowUser) {
        this.isShowUser = isShowUser;
    }

    public String getRemarkCus() {
        return remarkCus;
    }

    public void setRemarkCus(String remarkCus) {
        this.remarkCus = remarkCus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", lecturerUserNo=").append(lecturerUserNo);
        sb.append(", lecturerName=").append(lecturerName);
        sb.append(", userNo=").append(userNo);
        sb.append(", mobile=").append(mobile);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", courseId=").append(courseId);
        sb.append(", courseName=").append(courseName);
        sb.append(", pricePayable=").append(pricePayable);
        sb.append(", priceDiscount=").append(priceDiscount);
        sb.append(", pricePaid=").append(pricePaid);
        sb.append(", platformProfit=").append(platformProfit);
        sb.append(", lecturerProfit=").append(lecturerProfit);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", payType=").append(payType);
        sb.append(", channelType=").append(channelType);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", isShowLecturer=").append(isShowLecturer);
        sb.append(", isShowUser=").append(isShowUser);
        sb.append(", remarkCus=").append(remarkCus);
        sb.append(", remark=").append(remark);
        sb.append(", payTime=").append(payTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}