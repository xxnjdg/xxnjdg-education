package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.object.persistent.MsgTemplate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 消息模板 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface MsgTemplateMapper extends BaseMapper<MsgTemplate> {

    /**
     * 分页查询MsgTemplate列表
     * @param offset
     * @param size
     * @return
     */
    List<MsgTemplate> listMsgTemplateByPage(
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
