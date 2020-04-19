package io.xxnjdg.notp.user.object.persistent;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 讲师账户信息表
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LecturerExt implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 讲师用户编号
     */
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
