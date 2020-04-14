package io.xxnjdg.notp.user.model;

import java.io.Serializable;
import java.util.Date;

public class SendSmsLog implements Serializable {
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
     * 短信模板
     *
     * @mbg.generated
     */
    private String template;

    /**
     * 手机号码
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * 验证码
     *
     * @mbg.generated
     */
    private String smsCode;

    /**
     * 是否发送成功(1发送成功，0:发送失败)
     *
     * @mbg.generated
     */
    private Byte isSuccess;

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

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public Byte getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Byte isSuccess) {
        this.isSuccess = isSuccess;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", template=").append(template);
        sb.append(", mobile=").append(mobile);
        sb.append(", smsCode=").append(smsCode);
        sb.append(", isSuccess=").append(isSuccess);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}