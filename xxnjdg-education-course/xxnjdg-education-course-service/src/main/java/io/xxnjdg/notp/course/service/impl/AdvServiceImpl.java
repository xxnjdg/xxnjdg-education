package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.course.object.data.transfer.AdvDto;
import io.xxnjdg.notp.course.object.persistent.Adv;
import io.xxnjdg.notp.course.mapper.AdvMapper;
import io.xxnjdg.notp.course.object.view.AdvVo;
import io.xxnjdg.notp.course.service.AdvService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.ItemStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 广告信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class AdvServiceImpl extends ServiceImpl<AdvMapper, Adv> implements AdvService {

    @Override
    public List<AdvVo> postAdvList(AdvDto advDto) {

        LambdaQueryWrapper<Adv> advLambdaQueryWrapper = new QueryWrapper<Adv>().lambda()
                .eq(Adv::getPlatShow, advDto.getPlatShow())
                .eq(Adv::getStatusId, ItemStatus.ENABLE.getStatus())
                .lt(Adv::getBeginTime, DateUtil.parse("2018-01-01 01:00:00"))
                .gt(Adv::getEndTime, DateUtil.parse("2019-01-04 01:00:00"));

        List<Adv> list = this.list(advLambdaQueryWrapper);

        if(CollUtil.isEmpty(list)){
            return null;
        }

        //po -> vo
        List<AdvVo> advVos = new ArrayList<>();
        list.forEach(adv -> {
            AdvVo advVo = new AdvVo();
            BeanUtil.copyProperties(adv,advVo);
            advVos.add(advVo);
        });


        return advVos;
    }
}
