package io.xxnjdg.notp.system.service.impl;

import io.xxnjdg.notp.system.object.persistent.Sys;
import io.xxnjdg.notp.system.mapper.SysMapper;
import io.xxnjdg.notp.system.service.SysService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class SysServiceImpl extends ServiceImpl<SysMapper, Sys> implements SysService {

}
