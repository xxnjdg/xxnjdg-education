package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseCategoryDTO;
import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import io.xxnjdg.notp.utils.response.PageResult;

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

    /**
     * 分页查询列表
     * @param courseCategoryDTO
     * @return
     */
    PageResult<CourseCategoryBO> listCourseCategoryByPage(CourseCategoryDTO courseCategoryDTO);

    /**
     * 插入
     * @param courseCategoryDTO
     * @return
     */
    Boolean saveCourseCategory(CourseCategoryDTO courseCategoryDTO);

    /**
     * 更新
     * @param courseCategoryDTO
     * @return
     */
    Boolean updateCourseCategory(CourseCategoryDTO courseCategoryDTO);

    /**
     * 删除
     * @param courseCategoryDTO
     * @return
     */
    Boolean deleteCourseCategory(CourseCategoryDTO courseCategoryDTO);

    /**
     * 查询
     * @param courseCategoryDTO
     * @return
     */
    CourseCategoryBO getCourseCategory(CourseCategoryDTO courseCategoryDTO);
}
