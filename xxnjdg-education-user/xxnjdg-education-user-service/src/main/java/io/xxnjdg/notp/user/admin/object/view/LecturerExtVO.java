package io.xxnjdg.notp.user.admin.object.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 16:15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LecturerExtVO implements Serializable {

    private static final long serialVersionUID = 1L;

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
