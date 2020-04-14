package io.xxnjdg.notp.user.model;

import java.io.Serializable;
import java.util.Date;

public class UserLogLogin implements Serializable {
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
     * 用户编号
     *
     * @mbg.generated
     */
    private Long userNo;

    /**
     * 客户端ID
     *
     * @mbg.generated
     */
    private String clientId;

    /**
     * 登录状态(1成功，0失败)
     *
     * @mbg.generated
     */
    private Byte loginStatus;

    /**
     * 登录IP
     *
     * @mbg.generated
     */
    private String loginIp;

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

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Byte getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Byte loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", userNo=").append(userNo);
        sb.append(", clientId=").append(clientId);
        sb.append(", loginStatus=").append(loginStatus);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}