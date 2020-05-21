package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.object.persistent.WebsiteLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 站点友情链接 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface WebsiteLinkMapper extends BaseMapper<WebsiteLink> {

    /**
     * 分页查询WebsiteLink列表
     * @param statusId
     * @param linkName
     * @param offset
     * @param size
     * @return
     */
    List<WebsiteLink> listWebsiteLinkByPage(
            @Param("statusId") Integer statusId,
            @Param("linkName") String linkName,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
