package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.business.CourseBO;
import io.xxnjdg.notp.course.object.business.CourseDetailBO;
import io.xxnjdg.notp.course.object.data.transfer.CourseDetailDTO;
import io.xxnjdg.notp.course.object.data.transfer.CourseListDTO;
import io.xxnjdg.notp.course.object.persistent.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.view.CourseDetailVO;
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

    /**
     * 分页展示课程列表
     * @param courseListDTO courseListDTO
     * @return
     */
    PageResult<CourseListVO> postCourseListByPage(CourseListDTO courseListDTO);


    /**
     * 查询登陆课程详情页
     * @param courseDetailDTO CourseDetailDTO
     * @return CourseDetailVO
     */
    CourseDetailBO getCourseDetail(CourseDetailDTO courseDetailDTO);


    /**
     * id获取课程
     * @param id id
     * @return CourseBO
     */
    CourseBO getCourseById(Long id);
}
