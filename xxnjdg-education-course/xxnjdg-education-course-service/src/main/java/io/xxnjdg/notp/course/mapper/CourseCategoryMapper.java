package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程分类 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseCategoryMapper extends BaseMapper<CourseCategory> {

    /**
     * 分页查询列表
     * @param statusId
     * @param floor
     * @param categoryType
     * @param parentId
     * @param categoryName
     * @param offset
     * @param size
     * @return
     */
    List<CourseCategory> listCourseCategoryByPage(
            @Param("statusId") Integer statusId,
            @Param("floor") Integer floor,
            @Param("categoryType") Integer categoryType,
            @Param("parentId") Long parentId,
            @Param("categoryName") String categoryName,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
