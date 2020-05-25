package io.xxnjdg.notp.user.admin.object.convert;

import io.xxnjdg.notp.user.admin.object.business.UserExtBO;
import io.xxnjdg.notp.user.admin.object.data.transfer.UserExtDTO;
import io.xxnjdg.notp.user.admin.object.view.UserExtPageVO;
import io.xxnjdg.notp.user.admin.object.view.UserExtViewVO;
import io.xxnjdg.notp.user.object.persistent.UserExt;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 2:18
 */
@Mapper
public interface UserExtMapStruct {
    UserExtMapStruct INSTANCE = Mappers.getMapper(UserExtMapStruct.class);

    /**
     * DT2P
     * @param userExtDTO
     * @return
     */
    UserExt DT2P(UserExtDTO userExtDTO);


    /**
     * P2B
     * @param userExtBO
     * @return
     */
    UserExtViewVO B2VV(UserExtBO userExtBO);

    /**
     * P2B
     * @param userExt
     * @return
     */
    UserExtBO P2B(UserExt userExt);

    /**
     * P2B
     * @param userExtList
     * @return
     */
    List<UserExtBO> P2B(List<UserExt> userExtList);



    /**
     * B2V
     * @param userExtBO
     * @return
     */
    UserExtPageVO B2PV(UserExtBO userExtBO);

    /**
     * B2V
     * @param userExtBOList
     * @return
     */
    List<UserExtPageVO> B2PV(List<UserExtBO> userExtBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<UserExtPageVO> B2PV(PageResult<UserExtBO> result);
}