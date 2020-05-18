package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.MsgUserBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.MsgUserDTO;
import io.xxnjdg.notp.system.object.persistent.MsgUser;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 13:54
 */
public interface MsgUserAdminService extends IService<MsgUser> {
    /**
     * 分页查询MsgUser列表
     * @param msgUserDTO
     * @return
     */
    PageResult<MsgUserBO> listMsgUserByPage(MsgUserDTO msgUserDTO);

    /**
     * 删除 MsgUser
     * @param msgUserDTO
     * @return
     */
    Boolean deleteMsgUserById(MsgUserDTO msgUserDTO);

    /**
     * 查询 MsgUser
     * @param msgUserDTO
     * @return
     */
    MsgUserBO getMsgUserById(MsgUserDTO msgUserDTO);
}
