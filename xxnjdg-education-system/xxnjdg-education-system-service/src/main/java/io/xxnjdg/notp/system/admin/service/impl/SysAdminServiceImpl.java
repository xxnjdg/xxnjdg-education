package io.xxnjdg.notp.system.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.SysBO;
import io.xxnjdg.notp.system.admin.object.convert.SysMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysDTO;
import io.xxnjdg.notp.system.admin.object.error.SysEnum;
import io.xxnjdg.notp.system.admin.service.SysAdminService;
import io.xxnjdg.notp.system.mapper.SysMapper;
import io.xxnjdg.notp.system.object.persistent.Sys;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 20:51
 */
@Service
public class SysAdminServiceImpl extends ServiceImpl<SysMapper, Sys> implements SysAdminService {
    @Override
    public List<SysBO> listSys() {
        return SysMapStruct.INSTANCE.P2B(this.list());
    }

    @Override
    public Boolean updateSysById(SysDTO sysDTO) {
        Sys sys = SysMapStruct.INSTANCE.DTO2P(sysDTO);
        boolean update = this.updateById(sys);
        if (!update){
            throw new BaseException(SysEnum.UPDATE_ERROR);
        }
        return true;
    }
}
