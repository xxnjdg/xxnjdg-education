package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.ZoneBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.ZoneDTO;
import io.xxnjdg.notp.course.admin.object.view.ZonePageVO;
import io.xxnjdg.notp.course.admin.object.view.ZoneVO;
import io.xxnjdg.notp.course.object.persistent.Zone;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 21:11
 */
@Mapper
public interface ZoneMapStruct {
    ZoneMapStruct INSTANCE = Mappers.getMapper(ZoneMapStruct.class);

    /**
     * P2B
     * @param zone
     * @return
     */
    Zone DT2P(ZoneDTO zone);

    /**
     * P2B
     * @param zone
     * @return
     */
    ZoneBO P2B(Zone zone);


    /**
     * P2B
     * @param zoneList
     * @return
     */
    List<ZoneBO> P2B(List<Zone> zoneList);

    /**
     * B2V
     * @param zoneBO
     * @return
     */
    ZoneVO B2V(ZoneBO zoneBO);

    /**
     * B2V
     * @param zoneBO
     * @return
     */
    ZonePageVO B2PV(ZoneBO zoneBO);

    /**
     * B2V
     * @param zoneBOList
     * @return
     */
    List<ZonePageVO> B2PV(List<ZoneBO> zoneBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<ZonePageVO> B2PV(PageResult<ZoneBO> result);
}