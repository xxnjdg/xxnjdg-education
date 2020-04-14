package io.xxnjdg.notp.system.model;

import java.io.Serializable;
import java.util.Date;

public class MsgUser implements Serializable {
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
     * 短信ID
     *
     * @mbg.generated
     */
    private Long msgId;

    /**
     * 用户编号
     *
     * @mbg.generated
     */
    private Long userNo;

    /**
     * 手机号
     *
     * @mbg.generated
     */
    private String mobile;

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
     * 是否阅读(1是;0否)
     *
     * @mbg.generated
     */
    private Byte isRead;

    /**
     * 是否置顶(1是;0否)
     *
     * @mbg.generated
     */
    private Byte isTop;

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

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
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

    public Byte getIsRead() {
        return isRead;
    }

    public void setIsRead(Byte isRead) {
        this.isRead = isRead;
    }

    public Byte getIsTop() {
        return isTop;
    }

    public void setIsTop(Byte isTop) {
        this.isTop = isTop;
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
        sb.append(", msgId=").append(msgId);
        sb.append(", userNo=").append(userNo);
        sb.append(", mobile=").append(mobile);
        sb.append(", msgType=").append(msgType);
        sb.append(", msgTitle=").append(msgTitle);
        sb.append(", isRead=").append(isRead);
        sb.append(", isTop=").append(isTop);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}