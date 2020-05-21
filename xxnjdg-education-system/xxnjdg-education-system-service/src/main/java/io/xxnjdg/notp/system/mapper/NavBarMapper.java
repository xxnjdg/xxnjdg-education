package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.object.persistent.NavBar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 头部导航 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface NavBarMapper extends BaseMapper<NavBar> {

    /**
     * 分页查询NavBar列表
     * @param statusId
     * @param navTitle
     * @param offset
     * @param size
     * @return
     */
    List<NavBar> listNavBarByPage(
            @Param("statusId") Integer statusId,
            @Param("navTitle") String navTitle,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
