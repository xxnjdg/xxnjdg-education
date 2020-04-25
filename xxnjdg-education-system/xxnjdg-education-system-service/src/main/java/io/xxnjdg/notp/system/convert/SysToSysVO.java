package io.xxnjdg.notp.system.convert;

import io.xxnjdg.notp.system.object.persistent.Sys;
import io.xxnjdg.notp.system.objects.view.SysVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-25 下午11:25
 */
@Mapper
public interface SysToSysVO {
    SysToSysVO INSTANCE = Mappers.getMapper(SysToSysVO.class);

    SysVO convert(Sys sys);
}
