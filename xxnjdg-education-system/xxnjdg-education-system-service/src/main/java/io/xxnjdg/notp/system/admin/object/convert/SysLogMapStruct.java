package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.SysLogBO;
import io.xxnjdg.notp.system.admin.object.view.SysLogVO;
import io.xxnjdg.notp.system.object.persistent.SysLog;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 21:38
 */
@Mapper
public interface SysLogMapStruct {
    SysLogMapStruct INSTANCE = Mappers.getMapper(SysLogMapStruct.class);

    /**
     * P2B
     * @param sysLog
     * @return
     */
    SysLogBO P2B(SysLog sysLog);


    /**
     * P2B
     * @param sysLogs
     * @return
     */
    List<SysLogBO> P2B(List<SysLog> sysLogs);

    /**
     * B2V
     * @param sysLogBO
     * @return
     */
    SysLogVO B2V(SysLogBO sysLogBO);

    /**
     * B2V
     * @param sysLogBOList
     * @return
     */
    List<SysLogVO> B2V(List<SysLogBO> sysLogBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<SysLogVO> B2V(PageResult<SysLogBO> result);
}