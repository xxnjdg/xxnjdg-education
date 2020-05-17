package io.xxnjdg.notp.system.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Delete;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.Page;
import io.xxnjdg.notp.utils.validator.group.Update;
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
 * @date 2020/5/18 2:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MsgDTO implements Serializable {

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
     * 状态(1有效, 0无效)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class,Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Delete.class,Update.class})
    private Integer statusId;

    /**
     * 短信标题
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class,Update.class})
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class,Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Delete.class})
    private String msgTitle;

    /**
     * 是否已发送(1是;0否)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class,Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Delete.class,Update.class})
    private Integer isSend;

    /**
     * 是否置顶(1是;0否)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class,Page.class,Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Delete.class})
    private Integer isTop;

    /**
     * 短信类型(1系统消息,2其他)
     */
    @Range(min = 1, max = 2,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Delete.class,Update.class})
    private Integer msgType;

    /**
     * 发送时间
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Delete.class,Update.class})
    private LocalDateTime sendTime;

    /**
     * 短信内容
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Delete.class})
    private String msgText;

    /**
     * 是否定时发送（1是，0否）
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Delete.class,Update.class})
    private Integer isTimeSend;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Delete.class, Update.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Delete.class, Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class,Insert.class})
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
     * 排序
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer sort;

    /**
     * 后台备注
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String backRemark;


}