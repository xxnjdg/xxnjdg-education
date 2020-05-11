package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.object.data.transfer.CourseChapterAuditDTO;
import io.xxnjdg.notp.course.object.persistent.CourseChapterAudit;
import io.xxnjdg.notp.course.object.view.InsertCourseChapterAuditVO;
import io.xxnjdg.notp.course.object.view.ListCourseChapterAuditVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-10 下午5:01
 */
@Mapper
public interface CourseChapterAuditMapStruct {
    CourseChapterAuditMapStruct INSTANCE = Mappers.getMapper(CourseChapterAuditMapStruct.class);

    /**
     * DTO -> DO
     * @param courseChapterAuditDTO
     * @return
     */
    CourseChapterAudit convertDTO2D(CourseChapterAuditDTO courseChapterAuditDTO);

    /**
     * DO -> BO
     * @param courseChapterAudit
     * @return
     */
    CourseChapterAuditBO convertD2B(CourseChapterAudit courseChapterAudit);

    /**
     * BO -> VO
     * @param courseChapterAuditBO
     * @return
     */
    InsertCourseChapterAuditVO convertB2V(CourseChapterAuditBO courseChapterAuditBO);

    /**
     * DO -> BO
     * @param courseChapterAudits
     * @return
     */
    List<CourseChapterAuditBO> convertD2B(List<CourseChapterAudit> courseChapterAudits);

    /**
     * BO -> VO
     * @param courseChapterAuditBOS
     * @return
     */
    List<ListCourseChapterAuditVO> convertB2V(List<CourseChapterAuditBO> courseChapterAuditBOS);
}