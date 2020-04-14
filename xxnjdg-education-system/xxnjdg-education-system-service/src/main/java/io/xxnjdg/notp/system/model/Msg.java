package io.xxnjdg.notp.system.model;

import java.io.Serializable;
import java.util.Date;

public class Msg implements Serializable {
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
     * 状态(1有效, 0无效)
     *
     * @mbg.generated
     */
    private Byte statusId;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * 短信类型(1系统消息,2其他)
     *
     * @mbg.generated
     */
    private Byte msgType;

    /**
     * 短信标题
     *
     * @mbg.generated
     */
    private String msgTitle;

    /**
     * 是否定时发送（1是，0否）
     *
     * @mbg.generated
     */
    private Byte isTimeSend;

    /**
     * 发送时间
     *
     * @mbg.generated
     */
    private Date sendTime;

    /**
     * 是否已发送(1是;0否)
     *
     * @mbg.generated
     */
    private Byte isSend;

    /**
     * 是否置顶(1是;0否)
     *
     * @mbg.generated
     */
    private Byte isTop;

    /**
     * 后台备注
     *
     * @mbg.generated
     */
    private String backRemark;

    /**
     * 短信内容
     *
     * @mbg.generated
     */
    private String msgText;

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

    public Byte getStatusId() {
        return statusId;
    }

    public void setStatusId(Byte statusId) {
        this.statusId = statusId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getMsgType() {
        return msgType;
    }

    public void setMsgType(Byte msgType) {
        this.msgType = msgType;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public Byte getIsTimeSend() {
        return isTimeSend;
    }

    public void setIsTimeSend(Byte isTimeSend) {
        this.isTimeSend = isTimeSend;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Byte getIsSend() {
        return isSend;
    }

    public void setIsSend(Byte isSend) {
        this.isSend = isSend;
    }

    public Byte getIsTop() {
        return isTop;
    }

    public void setIsTop(Byte isTop) {
        this.isTop = isTop;
    }

    public String getBackRemark() {
        return backRemark;
    }

    public void setBackRemark(String backRemark) {
        this.backRemark = backRemark;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
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
        sb.append(", statusId=").append(statusId);
        sb.append(", sort=").append(sort);
        sb.append(", msgType=").append(msgType);
        sb.append(", msgTitle=").append(msgTitle);
        sb.append(", isTimeSend=").append(isTimeSend);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", isSend=").append(isSend);
        sb.append(", isTop=").append(isTop);
        sb.append(", backRemark=").append(backRemark);
        sb.append(", msgText=").append(msgText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}