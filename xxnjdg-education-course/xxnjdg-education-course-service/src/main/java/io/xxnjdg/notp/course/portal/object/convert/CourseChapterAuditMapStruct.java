package io.xxnjdg.notp.course.portal.object.convert;

import io.xxnjdg.notp.course.object.persistent.CourseChapterAudit;
import io.xxnjdg.notp.course.portal.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.audit.CourseChapterAuditSaveDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.audit.CourseChapterAuditUpdateDTO;
import io.xxnjdg.notp.course.portal.object.view.course.chapter.audit.CourseChapterAuditPageVO;
import io.xxnjdg.notp.course.portal.object.view.course.chapter.audit.CourseChapterAuditSaveVO;
import io.xxnjdg.notp.course.portal.object.view.course.chapter.audit.CourseChapterAuditUpdateVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 23:53
 */
@Mapper
public interface CourseChapterAuditMapStruct {
    CourseChapterAuditMapStruct INSTANCE = Mappers.getMapper(CourseChapterAuditMapStruct.class);

    /**
     * DT2P
     *
     * @param dt
     * @return
     */
    CourseChapterAudit DT2P(CourseChapterAuditUpdateDTO dt);

    /**
     * DT2P
     *
     * @param dt
     * @return
     */
    CourseChapterAudit DT2P(CourseChapterAuditSaveDTO dt);

    /**
     * P2B
     *
     * @param p
     * @return
     */
    CourseChapterAuditBO P2B(CourseChapterAudit p);

    /**
     * P2B
     *
     * @param pl
     * @return
     */
    List<CourseChapterAuditBO> P2B(List<CourseChapterAudit> pl);

    /**
     * B2V
     *
     * @param b
     * @return
     */
    CourseChapterAuditUpdateVO B2UV(CourseChapterAuditBO b);

    /**
     * B2V
     *
     * @param b
     * @return
     */
    CourseChapterAuditSaveVO B2SV(CourseChapterAuditBO b);

    /**
     * B2V
     *
     * @param b
     * @return
     */
    CourseChapterAuditPageVO B2PV(CourseChapterAuditBO b);


    /**
     * B2V
     *
     * @param bl
     * @return
     */
    List<CourseChapterAuditPageVO> B2PV(List<CourseChapterAuditBO> bl);
}