package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseBO;
import io.xxnjdg.notp.course.object.business.CourseDetailBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午5:56
 */
@Mapper
public interface CourseBOToDetailBO {
    CourseBOToDetailBO INSTANCE = Mappers.getMapper(CourseBOToDetailBO.class);

    /**
     * 转换
     * @param course course
     * @return  CourseBO
     */
    CourseDetailBO convert(CourseBO course);
}
