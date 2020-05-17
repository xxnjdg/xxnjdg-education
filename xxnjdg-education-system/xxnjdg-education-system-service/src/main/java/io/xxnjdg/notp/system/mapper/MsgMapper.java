package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.object.persistent.Msg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 站内信息表 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface MsgMapper extends BaseMapper<Msg> {


    /**
     * 分页查询Msg列表
     * @param statusId
     * @param isSend
     * @param isTop
     * @param msgTitle
     * @param offset
     * @param size
     * @return
     */
    List<Msg> listMsgByPage(
            @Param("statusId") Integer statusId,
            @Param("isSend") Integer isSend,
            @Param("isTop") Integer isTop,
            @Param("msgTitle") String msgTitle,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
