package io.xxnjdg.notp.course.mapper;

import io.xxnjdg.notp.course.object.data.transfer.ZoneDTO;
import io.xxnjdg.notp.course.object.persistent.Zone;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xxnjdg.notp.course.object.view.ZoneVO;

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
}
