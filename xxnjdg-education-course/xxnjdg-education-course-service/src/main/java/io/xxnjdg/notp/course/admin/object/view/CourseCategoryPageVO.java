package io.xxnjdg.notp.course.admin.object.view;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/23 23:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseCategoryPageVO implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 排序
     */
    private Integer sort;
    /**
     * 父分类ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
    private List<CourseCategoryPageVO> children;
}
