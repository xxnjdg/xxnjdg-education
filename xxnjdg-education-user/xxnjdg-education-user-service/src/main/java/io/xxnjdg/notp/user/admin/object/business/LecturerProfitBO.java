package io.xxnjdg.notp.user.admin.object.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 17:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LecturerProfitBO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
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


    /**
     * 讲师名称
     */
    private String lecturerName;
    /**
     * 讲师手机号
     */
    private String lecturerMobile;
}
