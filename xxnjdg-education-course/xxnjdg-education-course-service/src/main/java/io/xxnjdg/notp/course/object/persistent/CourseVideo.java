package io.xxnjdg.notp.course.object.persistent;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程视频信息
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseVideo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 课时ID
     */
    private Long periodId;

    /**
     * 视频名称
     */
    private String videoName;

    /**
     * 视频编号
     */
    private Long videoNo;

    /**
     * 视频状态(1待上传，2上传成功，3上传失败)
     */
    private Integer videoStatus;

    /**
     * 时长
     */
    private String videoLength;

    /**
     * 视频ID
     */
    private String videoVid;

    /**
     * 阿里云oas
     */
    private String videoOasId;


}
