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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/24 15:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LecturerDTO implements Serializable {

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
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class})
    private Integer statusId;
    /**
     * 讲师名称
     */
    @Length(max = 49,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Get.class})
    private String lecturerName;

    /**
     * 讲师手机
     */
    @Length(max = 11,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class,Get.class})
    private String lecturerMobile;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Update.class,Get.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class,Get.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class})
    private Long id;

    /**
     * 排序
     */
    @Range(min = 1,max = Integer.MAX_VALUE,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class})
    private Integer sort;

    /**
     * 讲师邮箱
     */
    @Pattern(regexp = IdentityUserPhoneAndEmailConstant.EMAIL_REGEX,message = ValidationMessage.PARAMETER_ERROR, groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class})
    private String lecturerEmail;

    /**
     * 职位
     */
    @Length(max = 49,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class})
    private String position;

    /**
     * 头像
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class})
    private String headImgUrl;

    /**
     * 简介
     */
    @Length(max = 2047,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class})
    private String introduce;

    /**
     * 讲师分成比例
     */
    @Pattern(regexp = RegexConstant.LECTURER_PROPORTION,message = ValidationMessage.PARAMETER_ERROR,groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Get.class})
    private String lecturerProportion;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;


    /**
     * 讲师用户编号
     */
    private Long lecturerUserNo;

}
