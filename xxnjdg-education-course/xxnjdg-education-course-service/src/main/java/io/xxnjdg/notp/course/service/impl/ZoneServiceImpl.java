package io.xxnjdg.notp.course.service.impl;

import io.xxnjdg.notp.course.object.data.transfer.ZoneDTO;
import io.xxnjdg.notp.course.object.persistent.Zone;
import io.xxnjdg.notp.course.mapper.ZoneMapper;
import io.xxnjdg.notp.course.object.view.ZoneVO;
import io.xxnjdg.notp.course.service.ZoneService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 专区 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class ZoneServiceImpl extends ServiceImpl<ZoneMapper, Zone> implements ZoneService {

    @Override
    public List<ZoneVO> postZoneCourseList(ZoneDTO zoneDTO) {
        List<ZoneVO> zoneVOS = baseMapper.postZoneCourseList(zoneDTO);
        return zoneVOS;
    }
}
