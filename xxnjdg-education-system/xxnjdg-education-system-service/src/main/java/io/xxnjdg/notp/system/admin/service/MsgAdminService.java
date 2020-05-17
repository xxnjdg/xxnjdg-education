package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.MsgBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgDTO;
import io.xxnjdg.notp.system.object.persistent.Msg;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 2:27
 */
public interface MsgAdminService extends IService<Msg> {
    /**
     * 分页查询Msg列表
     * @param msgDTO
     * @return
     */
    PageResult<MsgBO> listMsgByPage(MsgDTO msgDTO);

    /**
     * 插入msg
     * @param msgDTO
     * @return
     */
    Boolean saveMsg(MsgDTO msgDTO);

    /**
     * 删除msg
     * @param msgDTO
     * @return
     */
    Boolean deleteMsg(MsgDTO msgDTO);

    /**
     * 更新msg
     * @param msgDTO
     * @return
     */
    Boolean updateMsg(MsgDTO msgDTO);
}
