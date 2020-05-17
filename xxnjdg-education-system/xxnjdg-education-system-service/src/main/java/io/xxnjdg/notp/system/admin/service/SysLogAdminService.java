package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.SysLogBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysLogDTO;
import io.xxnjdg.notp.system.object.persistent.SysLog;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 21:33
 */
public interface SysLogAdminService extends IService<SysLog> {
    /**
     * 分页查询SysLog列表
     * @param sysLogDTO
     * @return
     */
    PageResult<SysLogBO> listSysLogByPage(SysLogDTO sysLogDTO);
}
