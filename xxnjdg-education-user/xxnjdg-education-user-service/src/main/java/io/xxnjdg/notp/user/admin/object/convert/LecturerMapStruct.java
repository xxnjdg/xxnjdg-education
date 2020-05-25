package io.xxnjdg.notp.user.admin.object.convert;

import io.xxnjdg.notp.user.admin.object.business.LecturerBO;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerDTO;
import io.xxnjdg.notp.user.admin.object.view.LecturerPageVO;
import io.xxnjdg.notp.user.admin.object.view.LecturerVO;
import io.xxnjdg.notp.user.admin.object.view.LecturerViewVO;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import io.xxnjdg.notp.user.object.persistent.LecturerAudit;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/23 16:21
 */
@Mapper
public interface LecturerMapStruct {
    LecturerMapStruct INSTANCE = Mappers.getMapper(LecturerMapStruct.class);

    /**
     * NA2A
     * @param lecturer
     * @return
     */
    LecturerAudit NA2A(Lecturer lecturer);

    /**
     * DT2P
     * @param lecturerDTO
     * @return
     */
    Lecturer DT2P(LecturerDTO lecturerDTO);

    /**
     * P2V
     * @param userBO
     * @return
     */
    LecturerVO P2V(Lecturer userBO);

    /**
     * P2V
     * @param userBO
     * @return
     */
    List<LecturerVO> P2V(List<Lecturer> userBO);

    /**
     * P2B
     * @param lecturer
     * @return
     */
    LecturerBO P2B(Lecturer lecturer);


    /**
     * P2B
     * @param lecturerList
     * @return
     */
    List<LecturerBO> P2B(List<Lecturer> lecturerList);


    /**
     * B2V
     * @param lecturerBO
     * @return
     */
    LecturerPageVO B2PV(LecturerBO lecturerBO);

    /**
     * B2V
     * @param lecturerBOList
     * @return
     */
    List<LecturerPageVO> B2PV(List<LecturerBO> lecturerBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<LecturerPageVO> B2PV(PageResult<LecturerBO> result);

    /**
     * B2V
     * @param lecturerBO
     * @return
     */
    LecturerViewVO B2VV(LecturerBO lecturerBO);

}