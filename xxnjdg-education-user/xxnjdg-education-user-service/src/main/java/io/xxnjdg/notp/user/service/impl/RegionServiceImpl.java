package io.xxnjdg.notp.user.service.impl;

import io.xxnjdg.notp.user.entity.Region;
import io.xxnjdg.notp.user.mapper.RegionMapper;
import io.xxnjdg.notp.user.service.RegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 行政区域表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

}
