package io.xxnjdg.notp.course.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.persistent.Adv;
import io.xxnjdg.notp.course.portal.object.business.AdvBO;
import io.xxnjdg.notp.course.portal.object.data.transfer.adv.AdvPageDTO;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/27 1:41
 */
public interface AdvPortalService extends IService<Adv> {
    /**
     * 查询
     * @param advPageDTO
     * @return
     */
    List<AdvBO> listAdv(AdvPageDTO advPageDTO);
}
