package io.xxnjdg.notp.user.admin.object.convert;

import io.xxnjdg.notp.user.admin.object.business.UserBO;
import io.xxnjdg.notp.user.admin.object.view.UserVO;
import io.xxnjdg.notp.user.object.persistent.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 13:20
 */
@Mapper
public interface UserMapStruct {
    UserMapStruct INSTANCE = Mappers.getMapper(UserMapStruct.class);


    /**
     * P2B
     * @param user
     * @return
     */
    UserBO P2B(User user);


    /**
     * B2V
     * @param userBO
     * @return
     */
    UserVO B2V(UserBO userBO);
}