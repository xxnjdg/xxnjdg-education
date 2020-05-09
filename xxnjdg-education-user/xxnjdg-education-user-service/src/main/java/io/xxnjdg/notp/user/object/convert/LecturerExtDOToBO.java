package io.xxnjdg.notp.user.object.convert;

import io.xxnjdg.notp.user.object.business.LecturerExtBO;
import io.xxnjdg.notp.user.object.persistent.LecturerExt;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-8 下午10:55
 */
@Mapper
public interface LecturerExtDOToBO {
    LecturerExtDOToBO INSTANCE = Mappers.getMapper(LecturerExtDOToBO.class);

    /**
     * 转换
     * @param lecturer
     * @return
     */
    LecturerExtBO convert(LecturerExt lecturer);
}