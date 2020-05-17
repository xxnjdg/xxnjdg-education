package io.xxnjdg.notp.system.mapper;

import io.xxnjdg.notp.system.object.persistent.SysLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台操作日志表 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
public interface SysLogMapper extends BaseMapper<SysLog> {

    /**
     * 分页查询SysLog列表
     * @param realName
     * @param beginDate
     * @param endDate
     * @param offset
     * @param size
     * @return
     */
    List<SysLog> listSysLogByPage(
            @Param("realName") String realName,
            @Param("beginDate") Date beginDate,
            @Param("endDate") Date endDate,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
