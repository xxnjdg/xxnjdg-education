package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseBO;
import io.xxnjdg.notp.course.object.persistent.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午5:35
 */
@Mapper
public interface CourseDOToBO {
    CourseDOToBO INSTANCE = Mappers.getMapper(CourseDOToBO.class);

    /**
     * 转换
     * @param course course
     * @return  CourseBO
     */
    CourseBO convert(Course course);
}
