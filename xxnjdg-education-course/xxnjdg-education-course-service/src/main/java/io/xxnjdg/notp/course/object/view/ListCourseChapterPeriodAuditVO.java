package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-11 下午9:56
 */
@Data
@Accessors(chain = true)
public class ListCourseChapterPeriodAuditVO implements Serializable {

    private static final long serialVersionUID = -3145491150306445775L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 审核状态(0:待审核;1:审核通过;2:审核不通过)
     */
    private Integer auditStatus;
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
     * 是否存在文档
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
     * 是否存在视频
     */
    private Integer isVideo;
    /**
     * 视频编号
     */
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
     * 视频Vid
     */
    private String videoVid;
    /**
     * 阿里云oas
     */
    private String videoOasId;

}
