package io.xxnjdg.notp.user.object.convert;

import io.xxnjdg.notp.user.object.data.transfer.UserLogLoginDTO;
import io.xxnjdg.notp.user.object.persistent.UserLogLogin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/16 1:12
 */
@Mapper
public interface UserLogLoginMapStruct {
    UserLogLoginMapStruct INSTANCE = Mappers.getMapper(UserLogLoginMapStruct.class);

    /**
     * DTO -> DO
     * @param userLogLoginDTO
     * @return
     */
    UserLogLogin convertDTO2D(UserLogLoginDTO userLogLoginDTO);


}