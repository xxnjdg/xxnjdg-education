package io.xxnjdg.notp.user.model;

import java.io.Serializable;
import java.util.Date;

public class UserLogModified implements Serializable {
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
     * 原手机号
     *
     * @mbg.generated
     */
    private String mobileOld;

    /**
     * 新手机
     *
     * @mbg.generated
     */
    private String mobileNew;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

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

    public String getMobileOld() {
        return mobileOld;
    }

    public void setMobileOld(String mobileOld) {
        this.mobileOld = mobileOld;
    }

    public String getMobileNew() {
        return mobileNew;
    }

    public void setMobileNew(String mobileNew) {
        this.mobileNew = mobileNew;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        sb.append(", mobileOld=").append(mobileOld);
        sb.append(", mobileNew=").append(mobileNew);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}