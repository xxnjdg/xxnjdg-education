package io.xxnjdg.notp.user.admin.object.convert;

import io.xxnjdg.notp.user.admin.object.business.PlatformBO;
import io.xxnjdg.notp.user.admin.object.data.transfer.PlatformDTO;
import io.xxnjdg.notp.user.admin.object.view.PlatformPageVO;
import io.xxnjdg.notp.user.admin.object.view.PlatformVO;
import io.xxnjdg.notp.user.object.persistent.Platform;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 21:56
 */
@Mapper
public interface PlatformMapStruct {
    PlatformMapStruct INSTANCE = Mappers.getMapper(PlatformMapStruct.class);

    /**
     * P2B
     * @param platformDTO
     * @return
     */
    Platform DTO2P(PlatformDTO platformDTO);

    /**
     * P2B
     * @param platform
     * @return
     */
    PlatformBO P2B(Platform platform);


    /**
     * P2B
     * @param platformList
     * @return
     */
    List<PlatformBO> P2B(List<Platform> platformList);

    /**
     * B2V
     * @param platformBO
     * @return
     */
    PlatformPageVO B2PV(PlatformBO platformBO);

    /**
     * B2V
     * @param platformBOList
     * @return
     */
    List<PlatformPageVO> B2PV(List<PlatformBO> platformBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<PlatformPageVO> B2PV(PageResult<PlatformBO> result);

    /**
     * B2V
     * @param platformBO
     * @return
     */
    PlatformVO B2V(PlatformBO platformBO);
}