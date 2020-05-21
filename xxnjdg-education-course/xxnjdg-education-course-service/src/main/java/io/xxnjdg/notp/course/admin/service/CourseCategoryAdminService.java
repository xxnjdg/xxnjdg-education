package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.object.persistent.CourseCategory;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 17:49
 */
public interface CourseCategoryAdminService extends IService<CourseCategory> {

    /**
     * 查询列表
     * @return
     */
    List<CourseCategoryBO> listCourseCategory();

}
