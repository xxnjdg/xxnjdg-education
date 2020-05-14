package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.object.data.transfer.CourseChapterPeriodAuditBTO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import io.xxnjdg.notp.course.object.view.ListCourseChapterPeriodAuditVO;
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
     * BTO -> DO
     * @param courseChapterPeriodAuditBTO
     * @return
     */
    CourseChapterPeriodAudit convertBTO2D(CourseChapterPeriodAuditBTO courseChapterPeriodAuditBTO);

    /**
     * DO -> BO
     * @param courseChapterPeriodAudit
     * @return
     */
    CourseChapterPeriodAuditBO convertD2B(CourseChapterPeriodAudit courseChapterPeriodAudit);

    /**
     * DO -> BO
     * @param courseChapterPeriodAudits
     * @return
     */
    List<CourseChapterPeriodAuditBO> convertD2B(List<CourseChapterPeriodAudit> courseChapterPeriodAudits);

    /**
     * BO -> VO
     * @param courseChapterPeriodAuditBOS
     * @return
     */
    List<ListCourseChapterPeriodAuditVO> convertB2V(List<CourseChapterPeriodAuditBO> courseChapterPeriodAuditBOS);
}