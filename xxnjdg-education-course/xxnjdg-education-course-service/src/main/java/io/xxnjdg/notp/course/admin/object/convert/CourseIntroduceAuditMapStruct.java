package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.CourseIntroduceAuditBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseIntroduceAuditDTO;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduce;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduceAudit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 12:43
 */
@Mapper
public interface CourseIntroduceAuditMapStruct {
    CourseIntroduceAuditMapStruct INSTANCE = Mappers.getMapper(CourseIntroduceAuditMapStruct.class);

    /**
     * CIA2CI
     * @param courseIntroduceAudit
     * @return
     */
    CourseIntroduce CIA2CI(CourseIntroduceAudit courseIntroduceAudit);

    /**
     * P2B
     * @param courseIntroduceAuditDTO
     * @return
     */
    CourseIntroduceAudit DT2P(CourseIntroduceAuditDTO courseIntroduceAuditDTO);

    /**
     * P2B
     * @param courseIntroduceAudit
     * @return
     */
    CourseIntroduceAuditBO P2B(CourseIntroduceAudit courseIntroduceAudit);


    /**
     * P2B
     * @param courseIntroduceAuditList
     * @return
     */
    List<CourseIntroduceAuditBO> P2B(List<CourseIntroduceAudit> courseIntroduceAuditList);

    /**
     * B2V
     * @param advBO
     * @return
     */
//    AdvPageVO B2PV(AdvBO advBO);

    /**
     * B2V
     * @param advBO
     * @return
     */
//    AdvVO B2V(AdvBO advBO);

    /**
     * B2V
     * @param advBOList
     * @return
     */
//    List<AdvPageVO> B2PV(List<AdvBO> advBOList);

    /**
     * B2V
     * @param result
     * @return
     */
//    PageResult<AdvPageVO> B2PV(PageResult<AdvBO> result);
}