package io.xxnjdg.notp.course.admin.object.data.transfer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
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
 * @date 2020/5/26 4:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseUserStudyLogDTO implements Serializable {

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
     * 用户编号
     */
    @NotNull(message = ValidationMessage.PARAMETER_NULL,groups = { Page.class})
    @Range(message = ValidationMessage.PARAMETER_OUT_OF_SCOPE,groups = {Page.class})
    private Long userNo;

    /**
     * 开始时间
     */
    @Length(max = 254, message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    private String beginGmtCreate;
    /**
     * 结束时间
     */
    @Length(max = 254, message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Page.class})
    private String endGmtCreate;

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
     * 课程编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long courseId;

    /**
     * 课程名称
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String courseName;

    /**
     * 章节编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long chapterId;

    /**
     * 章节名称
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String chapterName;

    /**
     * 课时编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long periodId;

    /**
     * 课时名称
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String periodName;

}
