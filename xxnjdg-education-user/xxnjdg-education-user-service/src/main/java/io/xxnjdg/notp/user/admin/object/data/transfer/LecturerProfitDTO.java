package io.xxnjdg.notp.user.admin.object.data.transfer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
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
public class LecturerProfitDTO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 当前页
     */
    @Pattern(regexp = "^[1-9]\\d*$",message = ValidationMessage.PARAMETER_ERROR)
    private String pageCurrent;

    /**
     * 每页记录数
     */
    @Pattern(regexp = "(^[1][0-9]$)|(^[2][0]$)|(^[1-9]$)",message = ValidationMessage.PARAMETER_ERROR)
    private String pageSize;

    /**
     * 分润状态（1确认中，2成功，3失败）
     */
    @Range(min = 1 ,max = 3,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class})
    private Integer profitStatus;

    /**
     * 讲师名称 没有这个字段
     */
    @Length(max = 49,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    private String lecturerName;
    /**
     * 开始时间 没有这个字段
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    private String beginDate;
    /**
     * 结束时间 没有这个字段
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    private String endDate;

    /**
     * 主键
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long id;

    /**
     * 创建时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime gmtCreate;

    /**
     * 讲师用户编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long lecturerUserNo;

    /**
     * 银行卡号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String bankCardNo;

    /**
     * 银行名称
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String bankName;

    /**
     * 银行支行名称
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String bankBranchName;

    /**
     * 银行开户名
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String bankUserName;

    /**
     * 银行身份证号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String bankIdCardNo;

    /**
     * 讲师收入
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal lecturerProfit;

    /**
     * 平台收入
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal platformProfit;

    /**
     * 备注
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String remark;


}