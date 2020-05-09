package io.xxnjdg.notp.user.object.convert;

import io.xxnjdg.notp.user.object.business.UserExtBO;
import io.xxnjdg.notp.user.object.persistent.UserExt;
import io.xxnjdg.notp.user.object.view.UserExtVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-9 下午1:44
 */
@Mapper
public interface UserExtMapper {
    UserExtMapper INSTANCE = Mappers.getMapper(UserExtMapper.class);

    /**
     * 转换
     * @param lecturer
     * @return
     */
    UserExtBO convertD2B(UserExt lecturer);

    /**
     * 转换
     * @param userExtBO
     * @return
     */
    UserExtVO convertB2V(UserExtBO userExtBO);
}