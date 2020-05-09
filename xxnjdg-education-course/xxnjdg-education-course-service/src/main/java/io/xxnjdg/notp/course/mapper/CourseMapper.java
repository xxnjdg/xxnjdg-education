package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.persistent.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xxnjdg.notp.course.object.view.CourseDetailVO;

/**
 * <p>
 * 课程信息 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface CourseMapper extends BaseMapper<Course> {


    /**
     * s
     * @param courseId courseId
     * @return CourseDetailVO
     */
    CourseDetailVO queryCourseAndCourseIntroduceByCourseId(Long courseId);
}
