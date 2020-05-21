package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.business.ZoneBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.ZoneDTO;
import io.xxnjdg.notp.course.object.persistent.Zone;
import io.xxnjdg.notp.utils.response.PageResult;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 21:08
 */
public interface ZoneAdminService extends IService<Zone> {
    /**
     * 分页查询zone列表
     * @param zoneDTO
     * @return
     */
    PageResult<ZoneBO> listZoneByPage(ZoneDTO zoneDTO);

    /**
     * 插入
     * @param zoneDTO
     * @return
     */
    Boolean saveZone(ZoneDTO zoneDTO);

    /**
     * 更新
     * @param zoneDTO
     * @return
     */
    Boolean updateZoneById(ZoneDTO zoneDTO);

    /**
     * 查询
     * @param zoneDTO
     * @return
     */
    ZoneBO getZoneById(ZoneDTO zoneDTO);

    /**
     * 删除
     * @param zoneDTO
     * @return
     */
    Boolean deleteZoneById(ZoneDTO zoneDTO);

    /**
     * 查询
     * @param zoneDTO
     * @return
     */
    List<ZoneBO> getZoneByMap(ZoneDTO zoneDTO);
}
