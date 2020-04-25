package io.xxnjdg.notp.system.convert;

import io.xxnjdg.notp.system.objects.view.SysVO;
import io.xxnjdg.notp.utils.objects.AliyunObj;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-26 上午12:28
 */
@Mapper
public interface SysVoToAliyunObj {

    SysVoToAliyunObj INSTANCE = Mappers.getMapper(SysVoToAliyunObj.class);

    /**
     * s
     * @param sysVO s
     * @return s
     */
    AliyunObj convert(SysVO sysVO);

}
