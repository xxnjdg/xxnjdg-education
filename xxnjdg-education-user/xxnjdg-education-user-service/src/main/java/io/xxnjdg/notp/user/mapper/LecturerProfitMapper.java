package io.xxnjdg.notp.user.mapper;

import cn.hutool.core.date.DateTime;
import io.xxnjdg.notp.user.object.persistent.LecturerProfit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 讲师提现日志表 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
public interface LecturerProfitMapper extends BaseMapper<LecturerProfit> {

    /**
     * 分页查询列表
     * @param userNoList
     * @param beginDate
     * @param endDate
     * @param profitStatus
     * @param offset
     * @param size
     * @return
     */
    List<LecturerProfit> listLecturerProfitByPage(
            @Param("userNoList") Collection<Long> userNoList,
            @Param("beginDate") DateTime beginDate,
            @Param("endDate") DateTime endDate,
            @Param("profitStatus") Integer profitStatus,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
