package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriod;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 19:01
 */
@Mapper
public interface CourseChapterPeriodAuditMapStruct {
    CourseChapterPeriodAuditMapStruct INSTANCE = Mappers.getMapper(CourseChapterPeriodAuditMapStruct.class);

    /**
     * A2NA
     * @param courseChapterPeriodAudit
     * @return
     */
    CourseChapterPeriod A2NA(CourseChapterPeriodAudit courseChapterPeriodAudit);

    /**
     * P2B
     * @param courseCategory
     * @return
     */
    CourseChapterPeriodAuditBO P2B(CourseChapterPeriodAudit courseCategory);


    /**
     * P2B
     * @param courseCategoryList
     * @return
     */
    List<CourseChapterPeriodAuditBO> P2B(List<CourseChapterPeriodAudit> courseCategoryList);

}