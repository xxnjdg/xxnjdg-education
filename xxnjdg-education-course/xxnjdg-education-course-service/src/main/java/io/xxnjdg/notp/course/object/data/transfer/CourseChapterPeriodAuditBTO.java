package io.xxnjdg.notp.course.object.data.transfer;

import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.validator.group.Insert;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-11 下午11:53
 */
@Data
@Accessors(chain = true)
public class CourseChapterPeriodAuditBTO implements Serializable {

    private static final long serialVersionUID = 7305562700820096663L;

    /**
     * 用户编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long userNo;

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
     * 排序
     */
    @Pattern(regexp = "^[1-254]$",message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    private String sort;

    /**
     * 审核状态(0:待审核;1:审核通过;2:审核不通过)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer auditStatus;

    /**
     * 审核意见
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String auditOpinion;

    /**
     * 课程ID
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long courseId;

    /**
     * 章节ID
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Pattern(regexp = "^[\\d]{1,20}$",message = ValidationMessage.PARAMETER_ERROR,groups = {Insert.class})
    private String chapterId;

    /**
     * 课时描述
     */
    @Size(max = 255,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class})
    private String periodDesc;

    /**
     * 是否免费：1免费，0收费
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL)
    @Pattern(regexp = "^[0-1]$",message = ValidationMessage.PARAMETER_ERROR)
    private String isFree;

    /**
     * 原价
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal periodOriginal;

    /**
     * 优惠价
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private BigDecimal periodDiscount;

    /**
     * 购买人数
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer countBuy;

    /**
     * 学习人数
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer countStudy;

    /**
     * 是否存在文档(1存在，0否)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Integer isDoc;

    /**
     * 文档名称
     */
    @Size(max = 255,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class})
    private String docName;

    /**
     * 文档地址
     */
    @Size(max = 255,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class})
    private String docUrl;

    /**
     * 课时名称
     */
    @NotBlank(message = ValidationMessage.PARAMETER_NULL,groups = {Insert.class})
    @Size(max = 255,message = ValidationMessage.PARAMETER_TOO_LONG,groups = {Insert.class})
    private String periodName;

    /**
     * 是否存在视频(1存在，0否)
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String isVideo;

    /**
     * 视频编号
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private Long videoNo;

    /**
     * 视频名称
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String videoName;

    /**
     * 时长
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String videoLength;

    /**
     * 视频VID
     */
    @Null(message = ValidationMessage.PARAMETER_ERROR)
    private String videoVid;
}
