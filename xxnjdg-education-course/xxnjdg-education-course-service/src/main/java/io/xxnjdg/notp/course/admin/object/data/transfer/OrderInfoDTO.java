package io.xxnjdg.notp.course.admin.object.data.transfer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.constant.RegexConstant;
import io.xxnjdg.notp.utils.validator.group.Get;
import io.xxnjdg.notp.utils.validator.group.ListGroup;
import io.xxnjdg.notp.utils.validator.group.Page;
import io.xxnjdg.notp.utils.validator.group.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 16:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfoDTO implements Serializable {

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
     * 讲师用户编号
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private Long lecturerUserNo;

    /**
     * 讲师名称
     */
    @Length(max = 49,message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private String lecturerName;
    /**
     * 用户电话
     */
    @Length(max = 11,message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private String mobile;

    /**
     * 订单号
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private Long orderNo;

    /**
     * 课程ID
     */
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private Long courseId;

    /**
     * 课程名称
     */
    @Length(max = 49,message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private String courseName;

    /**
     * 交易类型：1线上支付，2线下支付
     */
    @Range(min = 1,max = 2, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private Integer tradeType;

    /**
     * 支付方式：1微信支付，2支付宝支付
     */
    @Range(min = 1,max = 4, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class})
    @Null(message = ValidationMessage.PARAMETER_NULL,groups = {ListGroup.class,Get.class,Update.class})
    private Integer payType;

    /**
     * 购买渠道：1web
     */
    @Range(min = 1,max = 4, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private Integer channelType;

    /**
     * 订单状态：1待支付，2成功支付，3支付失败，4已关闭
     */
    @Range(min = 1,max = 6, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private Integer orderStatus;

    /**
     * 后台备注
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,ListGroup.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class})
    private String remark;

    /**
     * 支付开始时间
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private String beginPayTime;
    /**
     * 支付结束时间
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class,Update.class})
    private String endPayTime;

    /**
     * 开始金额
     */
    @Pattern(regexp = RegexConstant.COURSE_PRICE,message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class,Update.class})
    private String beginPaidPrice;

    /**
     * 结束金额
     */
    @Pattern(regexp = RegexConstant.COURSE_PRICE,message = ValidationMessage.PARAMETER_ERROR,groups = {ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class,Update.class})
    private String endPaidPrice;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Get.class,Update.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {ListGroup.class,Get.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class})
    private Long id;

    /**
     * 创建时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime gmtModified;

    /**
     * 用户编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long userNo;

    /**
     * 用户注册时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime registerTime;

    /**
     * 应付金额
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal pricePayable;

    /**
     * 优惠金额
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal priceDiscount;

    /**
     * 实付金额
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal pricePaid;

    /**
     * 平台收入
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal platformProfit;

    /**
     * 讲师收入
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal lecturerProfit;

    /**
     * 是否显示给讲师(1是，0否)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer isShowLecturer;

    /**
     * 是否显示给用户看(1是，0否)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer isShowUser;

    /**
     * 客户备注
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String remarkCus;

    /**
     * 支付时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private LocalDateTime payTime;



}
