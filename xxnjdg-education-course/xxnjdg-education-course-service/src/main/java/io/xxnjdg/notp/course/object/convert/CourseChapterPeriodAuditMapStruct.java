package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-10 下午5:42
 */
@Mapper
public interface CourseChapterPeriodAuditMapStruct {
    CourseChapterPeriodAuditMapStruct INSTANCE = Mappers.getMapper(CourseChapterPeriodAuditMapStruct.class);

    /**
     * DO -> BO
     * @param courseChapterPeriodAudits
     * @return
     */
    List<CourseChapterPeriodAuditBO> convertD2B(List<CourseChapterPeriodAudit> courseChapterPeriodAudits);
}