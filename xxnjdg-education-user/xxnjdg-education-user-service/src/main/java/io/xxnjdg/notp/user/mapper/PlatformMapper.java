package io.xxnjdg.notp.user.mapper;

import io.xxnjdg.notp.user.object.persistent.Platform;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 平台信息 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface PlatformMapper extends BaseMapper<Platform> {

    /**
     * 分页查询Platform列表
     * @param clientName
     * @param offset
     * @param size
     * @return
     */
    List<Platform> listPlatformByPage(
            @Param("clientName") String clientName,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
