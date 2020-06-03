package io.xxnjdg.notp.course.portal.object.convert;

import io.xxnjdg.notp.course.object.persistent.CourseChapterPeriodAudit;
import io.xxnjdg.notp.course.portal.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditSaveDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditUpdateDTO;
import io.xxnjdg.notp.course.portal.object.view.course.chapter.period.audit.CourseChapterPeriodAuditPageVO;
import io.xxnjdg.notp.course.portal.object.view.course.chapter.period.audit.CourseChapterPeriodAuditSaveVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/31 2:10
 */
@Mapper
public interface CourseChapterPeriodAuditMapStruct {
    CourseChapterPeriodAuditMapStruct INSTANCE = Mappers.getMapper(CourseChapterPeriodAuditMapStruct.class);



    /**
     * P2B
     *
     * @param
     * @return
     */
    CourseChapterPeriodAudit DT2P(CourseChapterPeriodAuditUpdateDTO dt);

    /**
     * P2B
     *
     * @param
     * @return
     */
    CourseChapterPeriodAudit DT2P(CourseChapterPeriodAuditSaveDTO dt);

    /**
     * P2B
     *
     * @param p
     * @return
     */
    CourseChapterPeriodAuditBO P2B(CourseChapterPeriodAudit p);

    /**
     * P2B
     *
     * @param pl
     * @return
     */
    List<CourseChapterPeriodAuditBO> P2B(List<CourseChapterPeriodAudit> pl);

    /**
     * B2V
     *
     * @param b
     * @return
     */
    CourseChapterPeriodAuditSaveVO B2SV(CourseChapterPeriodAuditBO b);

    /**
     * B2V
     *
     * @param b
     * @return
     */
    CourseChapterPeriodAuditPageVO B2PV(CourseChapterPeriodAuditBO b);


    /**
     * B2V
     *
     * @param bl
     * @return
     */
    List<CourseChapterPeriodAuditPageVO> B2PV(List<CourseChapterPeriodAuditBO> bl);

}
