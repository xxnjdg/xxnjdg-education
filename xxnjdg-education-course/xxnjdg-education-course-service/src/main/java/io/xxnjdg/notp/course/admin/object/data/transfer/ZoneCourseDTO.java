package io.xxnjdg.notp.course.admin.object.data.transfer;

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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 14:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZoneCourseDTO implements Serializable {

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
     * 专区编号
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = { Page.class,Insert.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Page.class,Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = { Update.class, Delete.class})
    private Long zoneId;

    /**
     * 课程ID
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = { Insert.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Insert.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = { Page.class,Update.class, Delete.class})
    private Long courseId;

    /**
     * 课程名称
     */
    @Length(max = 254,message = ValidationMessage.PARAMETER_ERROR,groups = {Page.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = { Insert.class,Update.class, Delete.class})
    private String courseName;

    /**
     * 主键
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = { Update.class, Delete.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Update.class, Delete.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = { Insert.class,Page.class})
    private Long id;

    /**
     * 状态(1:正常;0:禁用)
     */
    @Range(max = 1,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = { Insert.class,Page.class, Delete.class})
    private Integer statusId;

    /**
     * 排序
     */
    @Range(min=1,max= Integer.MAX_VALUE,message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = { Update.class})
    @Null(message = ValidationMessage.PARAMETER_ERROR,groups = { Insert.class,Page.class, Delete.class})
    private Integer sort;

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
     * 位置(0电脑端，1微信端)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer zoneLocation;

}
