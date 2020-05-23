package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.persistent.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xxnjdg.notp.course.object.view.CourseDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 分页查询列表
     * @param statusId
     * @param isPutaway
     * @param categoryId1
     * @param isFree
     * @param courseName
     * @param offset
     * @param size
     * @return
     */
    List<Course> listCourseByPage(
            @Param("statusId") Integer statusId,
            @Param("isPutaway") Integer isPutaway,
            @Param("categoryId1") Long categoryId1,
            @Param("isFree") Integer isFree,
            @Param("courseName") String courseName,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
