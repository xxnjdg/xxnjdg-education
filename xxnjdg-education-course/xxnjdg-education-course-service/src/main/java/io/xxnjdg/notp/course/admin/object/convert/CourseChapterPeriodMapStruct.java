package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseChapterPeriodBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriod;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/23 20:15
 */
@Mapper
public interface CourseChapterPeriodMapStruct {
    CourseChapterPeriodMapStruct INSTANCE = Mappers.getMapper(CourseChapterPeriodMapStruct.class);

    /**
     * P2B
     * @param courseChapterPeriod
     * @return
     */
    CourseChapterPeriodBO P2B(CourseChapterPeriod courseChapterPeriod);


    /**
     * P2B
     * @param courseChapterPeriodList
     * @return
     */
    List<CourseChapterPeriodBO> P2B(List<CourseChapterPeriod> courseChapterPeriodList);

}