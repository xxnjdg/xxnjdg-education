package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.admin.object.view.CourseAuditPageVO;
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
     * P2B
     * @param advDTO
     * @return
     */
//    Adv DTO2P(AdvDTO advDTO);

    /**
     * P2B
     * @param courseCategory
     * @return
     */
    CourseAuditBO P2B(CourseAudit courseCategory);


    /**
     * P2B
     * @param courseCategoryList
     * @return
     */
    List<CourseAuditBO> P2B(List<CourseAudit> courseCategoryList);

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