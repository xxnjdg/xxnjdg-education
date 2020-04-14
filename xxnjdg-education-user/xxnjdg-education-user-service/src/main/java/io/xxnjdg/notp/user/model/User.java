package io.xxnjdg.notp.user.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
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
     * 状态(1:正常，0:禁用)
     *
     * @mbg.generated
     */
    private Byte statusId;

    /**
     * 用户编号
     *
     * @mbg.generated
     */
    private Long userNo;

    /**
     * 手机号码
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * 密码盐
     *
     * @mbg.generated
     */
    private String mobileSalt;

    /**
     * 登录密码
     *
     * @mbg.generated
     */
    private String mobilePsw;

    /**
     * 用户来源(client_id)
     *
     * @mbg.generated
     */
    private String userSource;

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

    public String getMobileSalt() {
        return mobileSalt;
    }

    public void setMobileSalt(String mobileSalt) {
        this.mobileSalt = mobileSalt;
    }

    public String getMobilePsw() {
        return mobilePsw;
    }

    public void setMobilePsw(String mobilePsw) {
        this.mobilePsw = mobilePsw;
    }

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource;
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
        sb.append(", userNo=").append(userNo);
        sb.append(", mobile=").append(mobile);
        sb.append(", mobileSalt=").append(mobileSalt);
        sb.append(", mobilePsw=").append(mobilePsw);
        sb.append(", userSource=").append(userSource);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}