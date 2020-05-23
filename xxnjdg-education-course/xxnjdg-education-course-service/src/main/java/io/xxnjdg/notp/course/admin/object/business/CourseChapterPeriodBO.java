package io.xxnjdg.notp.course.admin.object.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/23 20:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseChapterPeriodBO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
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
     * 课程ID
     */
    private Long courseId;

    /**
     * 章节ID
     */
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
