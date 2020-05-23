package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseAuditDTO;
import io.xxnjdg.notp.course.admin.object.view.CourseAuditPageVO;
import io.xxnjdg.notp.course.object.persistent.Course;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 23:23
 */
@Mapper
public interface CourseAuditMapStruct {
    CourseAuditMapStruct INSTANCE = Mappers.getMapper(CourseAuditMapStruct.class);

    /**
     * CA2C
     * @param courseAudit
     * @return
     */
    Course CA2C(CourseAudit courseAudit);

    /**
     * P2B
     * @param courseAuditDTO
     * @return
     */
    CourseAudit DT2P(CourseAuditDTO courseAuditDTO);

    /**
     * P2B
     * @param courseAudit
     * @return
     */
    CourseAuditBO P2B(CourseAudit courseAudit);


    /**
     * P2B
     * @param courseAuditList
     * @return
     */
    List<CourseAuditBO> P2B(List<CourseAudit> courseAuditList);

    /**
     * B2V
     * @param advBO
     * @return
     */
//    AdvVO B2V(AdvBO advBO);

    /**
     * B2V
     * @param courseAuditBO
     * @return
     */
    CourseAuditPageVO B2PV(CourseAuditBO courseAuditBO);

    /**
     * B2V
     * @param courseAuditBOList
     * @return
     */
    List<CourseAuditPageVO> B2PV(List<CourseAuditBO> courseAuditBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<CourseAuditPageVO> B2PV(PageResult<CourseAuditBO> result);
}