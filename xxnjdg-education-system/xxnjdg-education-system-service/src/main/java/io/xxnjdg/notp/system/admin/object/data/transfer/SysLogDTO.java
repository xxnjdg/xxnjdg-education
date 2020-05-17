package io.xxnjdg.notp.system.admin.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 21:38
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysLogDTO implements Serializable {

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
     * 真实姓名
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String realName;

    /**
     * 查询结束时间
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String endDate;

    /**
     * 查询开始时间
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_TOO_LONG)
    private String beginDate;

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
     * 操作人
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long userNo;

    /**
     * IP地址
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String ip;

    /**
     * 用户操作
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String operation;

    /**
     * 请求方法
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String method;

    /**
     * 请求路径
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String path;

    /**
     * 请求参数
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String content;


}