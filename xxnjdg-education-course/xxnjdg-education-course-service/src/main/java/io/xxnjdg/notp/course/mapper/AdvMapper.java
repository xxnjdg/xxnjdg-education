package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.persistent.Adv;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 广告信息 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface AdvMapper extends BaseMapper<Adv> {
    /**
     * 分页查询adv列表
     * @param statusId
     * @param platShow
     * @param advTitle
     * @param offset
     * @param size
     * @return
     */
    List<Adv> listAdvByPage(
            @Param("statusId") Integer statusId,
            @Param("platShow") Integer platShow,
            @Param("advTitle") String advTitle,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
