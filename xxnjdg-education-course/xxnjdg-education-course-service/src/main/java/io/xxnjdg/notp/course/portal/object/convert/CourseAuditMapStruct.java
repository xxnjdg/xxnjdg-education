package io.xxnjdg.notp.course.portal.object.convert;

import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.course.portal.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.autdit.CourseAuditPutawayDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.autdit.CourseAuditSaveDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.autdit.CourseAuditUpdateDTO;
import io.xxnjdg.notp.course.portal.object.view.course.audit.CourseAuditPageVO;
import io.xxnjdg.notp.course.portal.object.view.course.audit.CourseAuditSaveVO;
import io.xxnjdg.notp.course.portal.object.view.course.audit.CourseAuditViewVO;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/27 4:28
 */
@Mapper
public interface CourseAuditMapStruct {
    CourseAuditMapStruct INSTANCE = Mappers.getMapper(CourseAuditMapStruct.class);


    /**
     * DT2P
     * @param dt
     * @return
     */
    CourseAudit DT2P(CourseAuditPutawayDTO dt);

    /**
     * DT2P
     * @param dt
     * @return
     */
    CourseAudit DT2P(CourseAuditUpdateDTO dt);

    /**
     * DT2P
     * @param dt
     * @return
     */
    CourseAudit DT2P(CourseAuditSaveDTO dt);

    /**
     * P2B
     * @param p
     * @return
     */
    CourseAuditBO P2B(CourseAudit p);

    /**
     * P2B
     * @param p
     * @return
     */
    List<CourseAuditBO> P2B(List<CourseAudit> p);

    /**
     * B2VV
     * @param b
     * @return
     */
    CourseAuditViewVO B2VV(CourseAuditBO b);

    /**
     * B2V
     * @param b
     * @return
     */
    CourseAuditPageVO B2PV(CourseAuditBO b);

    /**
     * B2SV
     * @param b
     * @return
     */
    CourseAuditSaveVO B2SV(CourseAuditBO b);


    /**
     * B2V
     * @param b
     * @return
     */
    List<CourseAuditPageVO> B2PV(List<CourseAuditBO> b);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<CourseAuditPageVO> B2PV(PageResult<CourseAuditBO> result);
}