package io.xxnjdg.notp.user.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LecturerExt implements Serializable {
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
     * 排序
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * 讲师用户编号
     *
     * @mbg.generated
     */
    private Long lecturerUserNo;

    /**
     * 总收入
     *
     * @mbg.generated
     */
    private BigDecimal totalIncome;

    /**
     * 已提金额
     *
     * @mbg.generated
     */
    private BigDecimal historyMoney;

    /**
     * 可提余额
     *
     * @mbg.generated
     */
    private BigDecimal enableBalances;

    /**
     * 冻结金额
     *
     * @mbg.generated
     */
    private BigDecimal freezeBalances;

    /**
     * sign
     *
     * @mbg.generated
     */
    private String sign;

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

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getHistoryMoney() {
        return historyMoney;
    }

    public void setHistoryMoney(BigDecimal historyMoney) {
        this.historyMoney = historyMoney;
    }

    public BigDecimal getEnableBalances() {
        return enableBalances;
    }

    public void setEnableBalances(BigDecimal enableBalances) {
        this.enableBalances = enableBalances;
    }

    public BigDecimal getFreezeBalances() {
        return freezeBalances;
    }

    public void setFreezeBalances(BigDecimal freezeBalances) {
        this.freezeBalances = freezeBalances;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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
        sb.append(", lecturerUserNo=").append(lecturerUserNo);
        sb.append(", totalIncome=").append(totalIncome);
        sb.append(", historyMoney=").append(historyMoney);
        sb.append(", enableBalances=").append(enableBalances);
        sb.append(", freezeBalances=").append(freezeBalances);
        sb.append(", sign=").append(sign);
        sb.append(", bankCardNo=").append(bankCardNo);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankBranchName=").append(bankBranchName);
        sb.append(", bankUserName=").append(bankUserName);
        sb.append(", bankIdCardNo=").append(bankIdCardNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}