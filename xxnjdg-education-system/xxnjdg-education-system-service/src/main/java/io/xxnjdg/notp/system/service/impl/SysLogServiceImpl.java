package io.xxnjdg.notp.system.service.impl;

import io.xxnjdg.notp.system.object.persistent.SysLog;
import io.xxnjdg.notp.system.mapper.SysLogMapper;
import io.xxnjdg.notp.system.service.SysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台操作日志表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

}
