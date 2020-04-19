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
 * 讲师提现日志表
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LecturerProfit implements Serializable {

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
     * 讲师用户编号
     */
    private Long lecturerUserNo;

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

    /**
     * 讲师收入
     */
    private BigDecimal lecturerProfit;

    /**
     * 平台收入
     */
    private BigDecimal platformProfit;

    /**
     * 分润状态（1确认中，2成功，3失败）
     */
    private Integer profitStatus;

    /**
     * 备注
     */
    private String remark;


}
