package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseChapterPeriodBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriod;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午9:32
 */
@Mapper
public interface CourseChapterPeriodDOToBO {
    CourseChapterPeriodDOToBO INSTANCE = Mappers.getMapper(CourseChapterPeriodDOToBO.class);

    /**
     * 转换
     * @param courseChapterPeriods courseChapterPeriods
     * @return  ist<CourseChapterPeriodBO>
     */
    List<CourseChapterPeriodBO> convert(List<CourseChapterPeriod> courseChapterPeriods);
}