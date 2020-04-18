package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.data.transfer.ZoneDTO;
import io.xxnjdg.notp.course.object.persistent.Zone;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.view.ZoneVO;

import java.util.List;

/**
 * <p>
 * 专区 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface ZoneService extends IService<Zone> {

    List<ZoneVO> postZoneCourseList(ZoneDTO zoneDTO);
}
