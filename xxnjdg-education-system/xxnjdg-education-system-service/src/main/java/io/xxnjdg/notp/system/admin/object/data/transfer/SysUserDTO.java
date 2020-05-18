package io.xxnjdg.notp.system.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.Page;
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
 * @date 2020/5/19 3:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserDTO implements Serializable {

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
     * 手机
     */
    @Length(max = 11,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class,Insert.class})
    private String mobile;

    /**
     * 用户编号
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class})
    private Long userNo;

    /**
     * 真实姓名
     */
    @Length(max = 49,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class})
    private String realName;

    /**
     * 备注
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class})
    private String remark;

    /**
     * 主键
     */
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
     * 状态(1:正常，0:禁用)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer statusId;

    /**
     * 排序
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer sort;


}