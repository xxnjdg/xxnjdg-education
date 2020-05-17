package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.MsgBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgDTO;
import io.xxnjdg.notp.system.admin.object.view.MsgVO;
import io.xxnjdg.notp.system.object.persistent.Msg;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 2:20
 */
@Mapper
public interface MsgMapStruct {
    MsgMapStruct INSTANCE = Mappers.getMapper(MsgMapStruct.class);

    /**
     * DTO2P
     * @param MsgDTO
     * @return
     */
    Msg DTO2P(MsgDTO MsgDTO);

    /**
     * P2B
     * @param sysLog
     * @return
     */
    MsgBO P2B(Msg sysLog);


    /**
     * P2B
     * @param sysLogs
     * @return
     */
    List<MsgBO> P2B(List<Msg> sysLogs);

    /**
     * B2V
     * @param sysLogBO
     * @return
     */
    MsgVO B2V(MsgBO sysLogBO);

    /**
     * B2V
     * @param sysLogBOList
     * @return
     */
    List<MsgVO> B2V(List<MsgBO> sysLogBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<MsgVO> B2V(PageResult<MsgBO> result);
}