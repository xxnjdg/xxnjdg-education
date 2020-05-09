package io.xxnjdg.notp.user.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-28 下午1:51
 */
@Data
public class LecturerExtVO implements Serializable {
    private static final long serialVersionUID = -639463728424368133L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;

    /**
     * 讲师用户编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lecturerUserNo;

    /**
     * 总收入
     */
    private BigDecimal totalIncome;

    /**
     * 已提金额
     */
    private BigDecimal historyMoney;

    /**
     * 可提余额
     */
    private BigDecimal enableBalances;

    /**
     * 冻结金额
     */
    private BigDecimal freezeBalances;

    /**
     * sign
     */
    private String sign;

    /**
     * 银行卡号
     */
    private String bankCardNo;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行支行名称
     */
    private String bankBranchName;

    /**
     * 银行开户名
     */
    private String bankUserName;

    /**
     * 银行身份证号
     */
    private String bankIdCardNo;
}
