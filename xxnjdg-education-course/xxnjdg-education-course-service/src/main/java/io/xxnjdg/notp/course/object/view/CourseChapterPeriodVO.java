package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-28 下午3:00
 */
@Data
public class CourseChapterPeriodVO implements Serializable {
    private static final long serialVersionUID = 4200739504494112930L;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;

    /**
     * 课程ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;

    /**
     * 章节ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chapterId;

    /**
     * 课时名称
     */
    private String periodName;

    /**
     * 课时描述
     */
    private String periodDesc;

    /**
     * 是否免费：1免费，0收费
     */
    private Integer isFree;

    /**
     * 原价
     */
    private BigDecimal periodOriginal;

    /**
     * 优惠价
     */
    private BigDecimal periodDiscount;

    /**
     * 购买人数
     */
    private Integer countBuy;

    /**
     * 学习人数
     */
    private Integer countStudy;

    /**
     * 是否存在文档(1存在，0否)
     */
    private Integer isDoc;

    /**
     * 文档名称
     */
    private String docName;

    /**
     * 文档地址
     */
    private String docUrl;

    /**
     * 是否存在视频(1存在，0否)
     */
    private String isVideo;

    /**
     * 视频编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long videoNo;

    /**
     * 视频名称
     */
    private String videoName;

    /**
     * 时长
     */
    private String videoLength;

    /**
     * 视频VID
     */
    private String videoVid;
}
