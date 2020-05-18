package io.xxnjdg.notp.system.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Delete;
import io.xxnjdg.notp.utils.validator.group.Get;
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
 * @date 2020/5/18 13:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MsgUserDTO implements Serializable {

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
     * 手机号
     */
    @Length(max = 11,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Delete.class, Get.class})
    private String mobile;

    /**
     * 短信标题
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = {Delete.class, Get.class})
    private String msgTitle;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = {Delete.class, Get.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Delete.class, Get.class})
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
     * 状态(1有效, 0无效)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer statusId;

    /**
     * 排序
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer sort;

    /**
     * 短信ID
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long msgId;

    /**
     * 用户编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long userNo;


    /**
     * 短信类型(1系统消息,2其他)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer msgType;

    /**
     * 是否阅读(1是;0否)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer isRead;

    /**
     * 是否置顶(1是;0否)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer isTop;


}