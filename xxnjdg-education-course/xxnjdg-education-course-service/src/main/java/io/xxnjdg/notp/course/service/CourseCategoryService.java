package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.view.CourseCategoryLevelVO;

import java.util.List;

/**
 * <p>
 * 课程分类 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseCategoryService extends IService<CourseCategory> {

    /**
     * d
     * @return s
     */
    List<CourseCategoryLevelVO> postCourseCategoryList();
}
