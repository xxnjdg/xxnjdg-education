package io.xxnjdg.notp.course.admin.object.business;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 17:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseCategoryBO implements Serializable {

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
     * 父分类ID
     */
    private Long parentId;

    /**
     * 分类类型(1课程，2资源)
     */
    private Integer categoryType;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 层级
     */
    private Integer floor;

    /**
     * 备注
     */
    private String remark;

    /**
     * 课程分类集合
     */
    private List<CourseCategoryBO> children;
}
