package io.xxnjdg.notp.user.admin.object.convert;

import io.xxnjdg.notp.user.admin.object.business.LecturerExtBO;
import io.xxnjdg.notp.user.admin.object.view.LecturerExtVO;
import io.xxnjdg.notp.user.object.persistent.LecturerExt;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 15:09
 */
@Mapper
public interface LecturerExtMapStruct {
    LecturerExtMapStruct INSTANCE = Mappers.getMapper(LecturerExtMapStruct.class);

    /**
     * P2B
     * @param lecturer
     * @return
     */
//    LecturerAudit DT2P(LecturerAuditDTO lecturer);

    /**
     * P2B
     * @param lecturerExt
     * @return
     */
    LecturerExtBO P2B(LecturerExt lecturerExt);


    /**
     * P2B
     * @param lecturerExt
     * @return
     */
    LecturerExtVO P2V(LecturerExt lecturerExt);


    /**
     * P2B
     * @param lecturerList
     * @return
     */
//    List<LecturerAuditBO> P2B(List<LecturerAudit> lecturerList);


    /**
     * B2V
     * @param lecturerBO
     * @return
     */
//    LecturerAuditPageVO B2PV(LecturerAuditBO lecturerBO);

    /**
     * B2V
     * @param lecturerBOList
     * @return
     */
//    List<LecturerAuditPageVO> B2PV(List<LecturerAuditBO> lecturerBOList);

    /**
     * B2V
     * @param result
     * @return
     */
//    PageResult<LecturerAuditPageVO> B2PV(PageResult<LecturerAuditBO> result);
}