package io.xxnjdg.notp.user.admin.object.convert;

import io.xxnjdg.notp.user.admin.object.view.LecturerVO;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
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
}