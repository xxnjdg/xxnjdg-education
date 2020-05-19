package io.xxnjdg.notp.user.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 13:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserDTO implements Serializable {

    private static final long serialVersionUID=1L;

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
     * 用户编号
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL)
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE)
    private Long userNo;

    /**
     * 手机号码
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String mobile;

    /**
     * 密码盐
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String mobileSalt;

    /**
     * 登录密码
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String mobilePsw;

    /**
     * 用户来源(client_id)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String userSource;


}