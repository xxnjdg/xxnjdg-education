package io.xxnjdg.notp.system.admin.object.convert;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 14:00
 */

import io.xxnjdg.notp.system.admin.object.business.MsgUserBO;
import io.xxnjdg.notp.system.admin.object.view.FullMsgUserVO;
import io.xxnjdg.notp.system.admin.object.view.MsgUserVO;
import io.xxnjdg.notp.system.object.persistent.MsgUser;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MsgUserMapStruct {
    MsgUserMapStruct INSTANCE = Mappers.getMapper(MsgUserMapStruct.class);

    /**
     * P2B
     * @param msgUser
     * @return
     */
    MsgUserBO P2B(MsgUser msgUser);


    /**
     * P2B
     * @param msgUserList
     * @return
     */
    List<MsgUserBO> P2B(List<MsgUser> msgUserList);

    /**
     * B2V
     * @param msgUserBO
     * @return
     */
    MsgUserVO B2V(MsgUserBO msgUserBO);

    /**
     * B2V
     * @param msgUserBOList
     * @return
     */
    List<MsgUserVO> B2V(List<MsgUserBO> msgUserBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<MsgUserVO> B2V(PageResult<MsgUserBO> result);

    /**
     * B2V
     * @param msgUserBO
     * @return
     */
    FullMsgUserVO B2FV(MsgUserBO msgUserBO);
}