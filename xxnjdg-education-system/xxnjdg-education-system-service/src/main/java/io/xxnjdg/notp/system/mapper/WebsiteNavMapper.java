package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.object.domain.WebsiteNavLevelDo;
import io.xxnjdg.notp.system.object.persistent.WebsiteNav;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

}
