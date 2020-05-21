package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.object.domain.WebsiteNavLevelDo;
import io.xxnjdg.notp.system.object.persistent.WebsiteNav;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 站点导航 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface WebsiteNavMapper extends BaseMapper<WebsiteNav> {

    /**
     * 返回
     * @return List<WebsiteNavLevelVo>
     */
    List<WebsiteNavLevelDo> getWebsiteNavLevelListByStatusId();

    /**
     * 分页查询WebsiteNav列表
     * @param statusId
     * @param parentId
     * @param navName
     * @param offset
     * @param size
     * @return
     */
    List<WebsiteNav> listWebsiteNavByPage(
            @Param("statusId") Integer statusId,
            @Param("parentId") Long parentId,
            @Param("navName") String navName,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
