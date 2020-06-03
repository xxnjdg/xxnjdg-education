package io.xxnjdg.notp.course.portal.object.view.course.chapter.period.audit;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/31 2:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseChapterPeriodAuditSaveVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 课时ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
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
     * 是否存在文档
     */
    private Integer isDoc;
}
