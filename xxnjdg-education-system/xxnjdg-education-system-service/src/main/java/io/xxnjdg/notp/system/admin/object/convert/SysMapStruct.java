package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.SysBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysDTO;
import io.xxnjdg.notp.system.admin.object.view.SysListVO;
import io.xxnjdg.notp.system.object.persistent.Sys;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 21:05
 */
@Mapper
public interface SysMapStruct {
    SysMapStruct INSTANCE = Mappers.getMapper(SysMapStruct.class);

    /**
     * DTO2P
     * @param sysDTO
     * @return
     */
    Sys DTO2P(SysDTO sysDTO);

    /**
     * P2B
     * @param sys
     * @return
     */
    SysBO P2B(Sys sys);


    /**
     * P2B
     * @param sysList
     * @return
     */
    List<SysBO> P2B(List<Sys> sysList);

    /**
     * B2V
     * @param sysBO
     * @return
     */
    SysListVO B2V(SysBO sysBO);

    /**
     * B2V
     * @param sysBOList
     * @return
     */
    List<SysListVO> B2V(List<SysBO> sysBOList);
}