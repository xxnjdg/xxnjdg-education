package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.data.transfer.ZoneDTO;
import io.xxnjdg.notp.course.object.persistent.Zone;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xxnjdg.notp.course.object.view.ZoneVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 专区 Mapper 接口
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface ZoneMapper extends BaseMapper<Zone> {

    /**
     * d
     * @param zoneDTO
     * @return
     */
    List<ZoneVO> postZoneCourseList(ZoneDTO zoneDTO);

    /**
     * 分页查询CourseAudit列表
     * @param statusId
     * @param zoneLocation
     * @param zoneName
     * @param offset
     * @param size
     * @return
     */
    List<Zone> listZoneByPage(
            @Param("statusId") Integer statusId,
            @Param("zoneLocation") Integer zoneLocation,
            @Param("zoneName") String zoneName,
            @Param("offset") Integer offset,
            @Param("size") Integer size);
}
