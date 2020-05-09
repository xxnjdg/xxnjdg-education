package io.xxnjdg.notp.user.object.convert;

import io.xxnjdg.notp.user.object.business.LecturerBO;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午10:24
 */
@Mapper
public interface LecturerDOToBO {
    LecturerDOToBO INSTANCE = Mappers.getMapper(LecturerDOToBO.class);

    /**
     * 转换
     * @param lecturer
     * @return
     */
    LecturerBO convert(Lecturer lecturer);
}