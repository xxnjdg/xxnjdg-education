package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.business.CourseBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseDTO;
import io.xxnjdg.notp.course.object.persistent.Course;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 16:22
 */
public interface CourseAdminService extends IService<Course> {

    /**
     * 查询
     * @param courseDTO
     * @return
     */
    List<CourseBO> getCourseByCourseName(CourseDTO courseDTO);


    /**
     * 查询
     * @param courseDTO
     * @return
     */
    CourseBO getCourseById(CourseDTO courseDTO);


    /**
     * 查询
     * @param courseDTO
     * @return
     */
    List<CourseBO> getCourseByMap(CourseDTO courseDTO);
}
