package io.xxnjdg.notp.course.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.admin.object.business.AdvBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.AdvDTO;
import io.xxnjdg.notp.course.object.persistent.Adv;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 13:50
 */
public interface AdvAdminService extends IService<Adv> {
    /**
     * 分页查询Adv列表
     * @param advDTO
     * @return
     */
    PageResult<AdvBO> listAdvByPage(AdvDTO advDTO);

    /**
     * 插入
     * @param advDTO
     * @return
     */
    Boolean saveAdv(AdvDTO advDTO);

    /**
     * 查询
     * @param advDTO
     * @return
     */
    AdvBO getAdvById(AdvDTO advDTO);

    /**
     * 更新
     * @param advDTO
     * @return
     */
    Boolean updateAdvById(AdvDTO advDTO);

    /**
     * 删除
     * @param advDTO
     * @return
     */
    Boolean deleteAdvById(AdvDTO advDTO);
}
