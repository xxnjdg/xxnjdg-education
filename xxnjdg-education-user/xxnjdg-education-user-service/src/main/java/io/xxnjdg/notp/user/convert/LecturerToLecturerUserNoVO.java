package io.xxnjdg.notp.user.convert;

import io.xxnjdg.notp.user.object.persistent.Lecturer;
import io.xxnjdg.notp.user.object.view.LecturerUserNoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-29 上午4:02
 */
@Mapper
public interface LecturerToLecturerUserNoVO {
    LecturerToLecturerUserNoVO INSTANCE = Mappers.getMapper(LecturerToLecturerUserNoVO.class);

    LecturerUserNoVO convert(Lecturer lecturer);
}
