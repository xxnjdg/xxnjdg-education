package io.xxnjdg.notp.course.service;

import io.xxnjdg.notp.course.object.data.transfer.AdvDTO;
import io.xxnjdg.notp.course.object.persistent.Adv;
import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.course.object.view.AdvVO;

import java.util.List;

/**
 * <p>
 * 广告信息 服务类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
public interface AdvService extends IService<Adv> {

    /**
     * x
     * @param advDto
     * @return
     */
    List<AdvVO> postAdvList(AdvDTO advDto);
}
