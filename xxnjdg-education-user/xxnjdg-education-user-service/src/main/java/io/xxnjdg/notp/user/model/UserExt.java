package io.xxnjdg.notp.user.model;

import java.io.Serializable;
import java.util.Date;

public class UserExt implements Serializable {
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
     * 用户类型(1用户，2讲师)
     *
     * @mbg.generated
     */
    private Byte userType;

    /**
     * 用户手机
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * 性别(1男，2女，3保密)
     *
     * @mbg.generated
     */
    private Byte sex;

    /**
     * 年龄
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     * 昵称
     *
     * @mbg.generated
     */
    private String nickname;

    /**
     * 头像地址
     *
     * @mbg.generated
     */
    private String headImgUrl;

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

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
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
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", statusId=").append(statusId);
        sb.append(", userNo=").append(userNo);
        sb.append(", userType=").append(userType);
        sb.append(", mobile=").append(mobile);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", nickname=").append(nickname);
        sb.append(", headImgUrl=").append(headImgUrl);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}