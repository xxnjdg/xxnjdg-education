package io.xxnjdg.notp.user.admin.object.data.transfer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.constant.IdentityUserPhoneAndEmailConstant;
import io.xxnjdg.notp.utils.validator.group.Get;
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
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 2:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserExtDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    @Pattern(regexp = "^[1-9]\\d*$", message = ValidationMessage.PARAMETER_ERROR)
    private String pageCurrent;

    /**
     * 每页记录数
     */
    @Pattern(regexp = "(^[1][0-9]$)|(^[2][0]$)|(^[1-9]$)", message = ValidationMessage.PARAMETER_ERROR)
    private String pageSize;

    /**
     * 开始时间
     */
    @Length(max = 254, message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR, groups = {Update.class,Get.class})
    private String beginGmtCreate;
    /**
     * 结束时间
     */
    @Length(max = 254, message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR, groups = {Update.class,Get.class})
    private String endGmtCreate;

    /**
     * 昵称
     */
    @Length(max = 49, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR, groups = {Get.class})
    private String nickname;


    /**
     * 状态(1:正常，0:禁用)
     */
    @Range(max = 1, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {Page.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR, groups = {Get.class})
    private Integer statusId;

    /**
     * 用户手机
     */
    @Length(max = 11, message = ValidationMessage.PARAMETER_TOO_LONG, groups = {Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR, groups = {Update.class,Get.class})
    private String mobile;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL, groups = {Update.class, Get.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {Update.class, Get.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR, groups = {Page.class})
    private Long id;

    /**
     * 性别(1男，2女，3保密)
     */
    @Range(min = 1, max = 3, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR, groups = {Page.class,Get.class})
    private Integer sex;

    /**
     * 年龄
     */
    @Range(min = 1, max = Integer.MAX_VALUE, message = ValidationMessage.PARAMETER_OUT_OF_SCOPE, groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR, groups = {Page.class,Get.class})
    private Integer age;

    /**
     * 头像地址
     */
    @Length(max = 254, message = ValidationMessage.PARAMETER_TOO_LONG, groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR, groups = {Page.class,Get.class})
    private String headImgUrl;

    /**
     * 备注
     */
    @Length(max = 254, message = ValidationMessage.PARAMETER_TOO_LONG, groups = {Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR, groups = {Page.class,Get.class})
    private String remark;

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
     * 用户类型(1用户，2讲师)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer userType;

}