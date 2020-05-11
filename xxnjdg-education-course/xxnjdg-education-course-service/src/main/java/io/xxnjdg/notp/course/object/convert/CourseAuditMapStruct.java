package io.xxnjdg.notp.course.object.convert;

import io.xxnjdg.notp.course.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.object.data.transfer.CourseAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.InsertCourseAuditDTO;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.course.object.view.CourseAuditVO;
import io.xxnjdg.notp.course.object.view.InsertCourseAuditVO;
import io.xxnjdg.notp.course.object.view.ListCourseAuditVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-9 下午10:05
 */
@Mapper
public interface CourseAuditMapStruct {
    CourseAuditMapStruct INSTANCE = Mappers.getMapper(CourseAuditMapStruct.class);

    /**
     * BO -> VO
     * @param courseAudit
     * @return
     */
    CourseAuditVO mapB2V(CourseAuditBO courseAudit);

    /**
     * DO -> BO
     * @param courseAudits
     * @return
     */
    CourseAuditBO convertD2B(CourseAudit courseAudits);

    /**
     * DO -> BO
     * @param courseAudits
     * @return
     */
    List<CourseAuditBO> convertD2B(List<CourseAudit> courseAudits);

    /**
     * BO -> VO
     * @param courseAuditBO
     * @return
     */
    ListCourseAuditVO convertB2lV(CourseAuditBO courseAuditBO);

    /**
     * BO -> VO
     * @param courseAuditBOS
     * @return
     */
    List<ListCourseAuditVO> convertB2V(List<CourseAuditBO> courseAuditBOS);

    /**
     * BO -> VO
     * @param courseAuditBO
     * @return
     */
    InsertCourseAuditVO convertB2V(CourseAuditBO courseAuditBO);

    /**
     * DTO -> DO
     * @param insertCourseAuditDTO
     * @return
     */
    CourseAudit convertBTO2D(InsertCourseAuditDTO insertCourseAuditDTO);


    /**
     * DTO -> DO
     * @param courseAuditDTO
     * @return
     */
    CourseAudit convertBTO2D(CourseAuditDTO courseAuditDTO);
}