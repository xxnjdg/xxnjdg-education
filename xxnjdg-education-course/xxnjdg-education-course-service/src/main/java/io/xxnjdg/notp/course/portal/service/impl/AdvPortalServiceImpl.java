package io.xxnjdg.notp.course.portal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.mapper.AdvMapper;
import io.xxnjdg.notp.course.object.persistent.Adv;
import io.xxnjdg.notp.course.portal.object.business.AdvBO;
import io.xxnjdg.notp.course.portal.object.convert.AdvMapStruct;
import io.xxnjdg.notp.course.portal.object.data.transfer.adv.AdvPageDTO;
import io.xxnjdg.notp.course.portal.service.AdvPortalService;
import io.xxnjdg.notp.utils.constant.RowStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/27 1:42
 */
@Service
public class AdvPortalServiceImpl extends ServiceImpl<AdvMapper, Adv> implements AdvPortalService {
    @Override
    public List<AdvBO> listAdv(AdvPageDTO advPageDTO) {
        LambdaQueryWrapper<Adv> wrapper = new QueryWrapper<Adv>().lambda()
                .eq(Adv::getPlatShow, advPageDTO.getPlatShow())
                .eq(Adv::getStatusId, RowStatus.ENABLE)
                .lt(Adv::getBeginTime, LocalDateTime.now())
                .gt(Adv::getEndTime, LocalDateTime.now());

        return AdvMapStruct.INSTANCE.P2B(this.list(wrapper));
    }
}
