package io.xxnjdg.notp.course.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import io.xxnjdg.notp.course.portal.object.business.CourseCategoryBO;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 18:50
 */
public interface CourseCategoryPortalService extends IService<CourseCategory> {
    /**
     * 查询
     * @return
     */
    List<CourseCategoryBO> listCourseCategory();
}
