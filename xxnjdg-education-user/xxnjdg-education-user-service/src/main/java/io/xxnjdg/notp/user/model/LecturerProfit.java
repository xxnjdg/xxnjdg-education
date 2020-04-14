package io.xxnjdg.notp.user.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LecturerProfit implements Serializable {
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
     * 讲师用户编号
     *
     * @mbg.generated
     */
    private Long lecturerUserNo;

    /**
     * 银行卡号
     *
     * @mbg.generated
     */
    private String bankCardNo;

    /**
     * 银行名称
     *
     * @mbg.generated
     */
    private String bankName;

    /**
     * 银行支行名称
     *
     * @mbg.generated
     */
    private String bankBranchName;

    /**
     * 银行开户名
     *
     * @mbg.generated
     */
    private String bankUserName;

    /**
     * 银行身份证号
     *
     * @mbg.generated
     */
    private String bankIdCardNo;

    /**
     * 讲师收入
     *
     * @mbg.generated
     */
    private BigDecimal lecturerProfit;

    /**
     * 平台收入
     *
     * @mbg.generated
     */
    private BigDecimal platformProfit;

    /**
     * 分润状态（1确认中，2成功，3失败）
     *
     * @mbg.generated
     */
    private Byte profitStatus;

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

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public String getBankIdCardNo() {
        return bankIdCardNo;
    }

    public void setBankIdCardNo(String bankIdCardNo) {
        this.bankIdCardNo = bankIdCardNo;
    }

    public BigDecimal getLecturerProfit() {
        return lecturerProfit;
    }

    public void setLecturerProfit(BigDecimal lecturerProfit) {
        this.lecturerProfit = lecturerProfit;
    }

    public BigDecimal getPlatformProfit() {
        return platformProfit;
    }

    public void setPlatformProfit(BigDecimal platformProfit) {
        this.platformProfit = platformProfit;
    }

    public Byte getProfitStatus() {
        return profitStatus;
    }

    public void setProfitStatus(Byte profitStatus) {
        this.profitStatus = profitStatus;
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
        sb.append(", lecturerUserNo=").append(lecturerUserNo);
        sb.append(", bankCardNo=").append(bankCardNo);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankBranchName=").append(bankBranchName);
        sb.append(", bankUserName=").append(bankUserName);
        sb.append(", bankIdCardNo=").append(bankIdCardNo);
        sb.append(", lecturerProfit=").append(lecturerProfit);
        sb.append(", platformProfit=").append(platformProfit);
        sb.append(", profitStatus=").append(profitStatus);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}