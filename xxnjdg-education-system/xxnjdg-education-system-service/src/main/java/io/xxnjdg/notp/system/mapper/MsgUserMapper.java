package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.object.persistent.MsgUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 站内信用户记录表 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface MsgUserMapper extends BaseMapper<MsgUser> {

    /**
     * 分页查询MsgUser列表
     * @param mobile
     * @param msgTitle
     * @param offset
     * @param size
     * @return
     */
    List<MsgUser> listMsgUserByPage(
            @Param("mobile") String mobile,
            @Param("msgTitle") String msgTitle,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
