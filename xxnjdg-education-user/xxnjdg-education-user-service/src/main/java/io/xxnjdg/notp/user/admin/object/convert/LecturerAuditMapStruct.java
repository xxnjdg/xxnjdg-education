package io.xxnjdg.notp.user.admin.object.convert;

import io.xxnjdg.notp.user.admin.object.business.LecturerAuditBO;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerAuditDTO;
import io.xxnjdg.notp.user.admin.object.view.LecturerAuditPageVO;
import io.xxnjdg.notp.user.admin.object.view.LecturerAuditViewVO;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import io.xxnjdg.notp.user.object.persistent.LecturerAudit;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/24 16:04
 */
@Mapper
public interface LecturerAuditMapStruct {
    LecturerAuditMapStruct INSTANCE = Mappers.getMapper(LecturerAuditMapStruct.class);

    /**
     * P2B
     * @param lecturerAudit
     * @return
     */
    Lecturer A2NA(LecturerAudit lecturerAudit);

    /**
     * P2B
     * @param lecturerAuditDTO
     * @return
     */
    LecturerAudit DT2P(LecturerAuditDTO lecturerAuditDTO);

    /**
     * P2B
     * @param lecturerAudit
     * @return
     */
    LecturerAuditBO P2B(LecturerAudit lecturerAudit);


    /**
     * P2B
     * @param lecturerAuditList
     * @return
     */
    List<LecturerAuditBO> P2B(List<LecturerAudit> lecturerAuditList);


    /**
     * B2V
     * @param lecturerBO
     * @return
     */
    LecturerAuditPageVO B2PV(LecturerAuditBO lecturerBO);

    /**
     * B2V
     * @param lecturerBOList
     * @return
     */
    List<LecturerAuditPageVO> B2PV(List<LecturerAuditBO> lecturerBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<LecturerAuditPageVO> B2PV(PageResult<LecturerAuditBO> result);

    /**
     * B2V
     * @param lecturerBO
     * @return
     */
    LecturerAuditViewVO B2VV(LecturerAuditBO lecturerBO);


}