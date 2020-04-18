package io.xxnjdg.notp.course.object.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-17 下午2:08
 */
@Data
public class CourseCategoryLevelVO {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 层级
     */
    private Integer floor;

    /**
     * 分类备注信息
     */
    private String remark;
    /**
     * 排序
     */
    @JsonIgnore
    private Integer sort;

    /**
     * 父分类ID
     */
    @JsonIgnore
    private Long parentId;

    /**
     * 课程孩子
     */
    private List<?> children = new ArrayList<>();

}
