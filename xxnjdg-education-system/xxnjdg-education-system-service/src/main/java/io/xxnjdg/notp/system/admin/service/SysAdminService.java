package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.SysBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysDTO;
import io.xxnjdg.notp.system.object.persistent.Sys;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 20:51
 */
public interface SysAdminService extends IService<Sys> {
    /**
     * 查询sys列表
     * @return
     */
    List<SysBO> listSys();

    /**
     * 修改 sys
     * @param sysDTO
     * @return
     */
    Boolean updateSysById(SysDTO sysDTO);
}
