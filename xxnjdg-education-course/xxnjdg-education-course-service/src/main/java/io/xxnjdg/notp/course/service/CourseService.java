package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.data.transfer.CourseListDTO;
import io.xxnjdg.notp.course.object.persistent.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.view.CourseListVO;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * <p>
 * 课程信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseService extends IService<Course> {

    PageResult<CourseListVO> postCourseListByPage(CourseListDTO courseListDTO);
}
