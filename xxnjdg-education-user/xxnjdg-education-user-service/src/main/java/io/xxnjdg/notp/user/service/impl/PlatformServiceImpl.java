package io.xxnjdg.notp.user.service.impl;

import io.xxnjdg.notp.user.object.persistent.Platform;
import io.xxnjdg.notp.user.mapper.PlatformMapper;
import io.xxnjdg.notp.user.service.PlatformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 平台信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Service
public class PlatformServiceImpl extends ServiceImpl<PlatformMapper, Platform> implements PlatformService {

}
