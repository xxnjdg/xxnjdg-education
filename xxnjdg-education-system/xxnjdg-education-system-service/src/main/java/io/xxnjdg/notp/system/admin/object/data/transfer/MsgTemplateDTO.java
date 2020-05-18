package io.xxnjdg.notp.system.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
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
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 16:13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MsgTemplateDTO implements Serializable {

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
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Delete.class, Update.class, Get.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Delete.class, Update.class, Get.class})
    @Null(message = ValidationMessage.PARAMETER_NULL,groups = {Page.class,Insert.class})
    private Long id;

    /**
     * 标题
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Length(max=254,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_NULL,groups = {Page.class,Delete.class, Get.class})
    private String title;

    /**
     * 备注
     */
    @Length(max=1022,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_NULL,groups = {Page.class,Delete.class, Get.class})
    private String remark;

    /**
     * 创建时间
     */
    @Null(message = ValidationMessage.PARAMETER_NULL)
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @Null(message = ValidationMessage.PARAMETER_NULL)
    private LocalDateTime gmtModified;

    /**
     * 状态(1有效, 0无效)
     */
    @Null(message = ValidationMessage.PARAMETER_NULL)
    private Integer statusId;

    /**
     * 排序
     */
    @Null(message = ValidationMessage.PARAMETER_NULL)
    private Integer sort;


}