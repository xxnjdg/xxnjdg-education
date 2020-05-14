package io.xxnjdg.notp.course.object.persistent;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课时信息-审核
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseChapterPeriodAudit implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 审核状态(0:待审核;1:审核通过;2:审核不通过)
     */
    private Integer auditStatus;

    /**
     * 审核意见
     */
    private String auditOpinion;

    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 章节ID
     */
    private Long chapterId;

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
     * 课时名称
     */
    private String periodName;

    /**
     * 是否存在视频(1存在，0否)
     */
    private String isVideo;

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
     * 视频VID
     */
    private String videoVid;


}
