package io.xxnjdg.notp.user.admin.object.data.transfer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.constant.IdentityUserPhoneAndEmailConstant;
import io.xxnjdg.notp.utils.validator.constant.RegexConstant;
import io.xxnjdg.notp.utils.validator.group.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/24 16:04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LecturerAuditDTO implements Serializable {

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
     * 状态(1:正常，0:禁用)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class, View.class,ListGroup.class,Get.class})
    private Integer statusId;
    /**
     * 讲师名称
     */
    @Length(max = 49,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class, Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {View.class,ListGroup.class,Get.class})
    private String lecturerName;

    /**
     * 讲师手机
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class,Get.class})
    @Pattern(regexp = IdentityUserPhoneAndEmailConstant.PHONE_REGEX,message = ValidationMessage.PARAMETER_ERROR, groups = {Insert.class,Get.class})
    @Length(max = 11,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {View.class,ListGroup.class,Update.class})
    private String lecturerMobile;

    /**
     * 审核状态(0:待审核,1:审核通过,2:审核不通过)
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {ListGroup.class})
    @Range(max = 2,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class,Update.class,View.class,Get.class})
    private Integer auditStatus;

    /**
     * 讲师邮箱
     */
    @Pattern(regexp = IdentityUserPhoneAndEmailConstant.EMAIL_REGEX,message = ValidationMessage.PARAMETER_ERROR, groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,View.class,ListGroup.class,Get.class})
    private String lecturerEmail;


    /**
     * 职位
     */
    @Length(max = 49,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,View.class,ListGroup.class,Get.class})
    private String position;

    /**
     * 头像
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,View.class,ListGroup.class,Get.class})
    private String headImgUrl;

    /**
     * 简介
     */
    @Length(max = 2047,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,View.class,ListGroup.class,Get.class})
    private String introduce;

    /**
     * 讲师分成比例
     */
    @Pattern(regexp = RegexConstant.LECTURER_PROPORTION,message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,View.class,ListGroup.class,Get.class})
    private String lecturerProportion;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class,View.class,ListGroup.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class,View.class,ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Insert.class,Get.class})
    private Long id;

    /**
     * 排序
     */
    @Range(min = 1,max = Integer.MAX_VALUE,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Insert.class,View.class,ListGroup.class,Get.class})
    private Integer sort;

    /**
     * 审核意见
     */
    @Length(max = 1023,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {ListGroup.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Insert.class,View.class,Update.class,ListGroup.class,Get.class})
    private String auditOpinion;

    /**
     * 用戶登陆密码（如果用户不存在）
     */
    @Pattern(regexp = RegexConstant.PASSWORD,message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Update.class,View.class,ListGroup.class,Get.class})
    private String mobilePsw;
    /**
     * 用戶确认密码（如果用户不存在）
     */
    @Pattern(regexp = RegexConstant.PASSWORD,message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Update.class,View.class,ListGroup.class,Get.class})
    private String confirmPasswd;


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
     * 讲师用户编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long lecturerUserNo;

}
