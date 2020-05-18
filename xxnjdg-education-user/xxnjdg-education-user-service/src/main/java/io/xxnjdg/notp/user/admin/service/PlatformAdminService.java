package io.xxnjdg.notp.user.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.user.admin.object.business.PlatformBO;
import io.xxnjdg.notp.user.admin.object.data.transfer.PlatformDTO;
import io.xxnjdg.notp.user.object.persistent.Platform;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 21:44
 */
public interface PlatformAdminService extends IService<Platform> {
    /**
     * 分页查询Platform列表
     * @param platformDTO
     * @return
     */
    PageResult<PlatformBO> listPlatformByPage(PlatformDTO platformDTO);

    /**
     * 插入Platform
     * @param platformDTO
     * @return
     */
    Boolean savePlatform(PlatformDTO platformDTO);

    /**
     * 更新Platform
     * @param platformDTO
     * @return
     */
    Boolean updatePlatformById(PlatformDTO platformDTO);

    /**
     * 删除Platform
     * @param platformDTO
     * @return
     */
    Boolean deletePlatformById(PlatformDTO platformDTO);

    /**
     * 查询Platform
     * @param platformDTO
     * @return
     */
    PlatformBO getPlatformById(PlatformDTO platformDTO);
}
