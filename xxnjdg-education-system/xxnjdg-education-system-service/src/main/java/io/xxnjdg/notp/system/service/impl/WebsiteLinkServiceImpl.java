package io.xxnjdg.notp.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.object.persistent.WebsiteLink;
import io.xxnjdg.notp.system.mapper.WebsiteLinkMapper;
import io.xxnjdg.notp.system.object.view.WebsiteLinkVO;
import io.xxnjdg.notp.system.service.WebsiteLinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.ItemStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 站点友情链接 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class WebsiteLinkServiceImpl extends ServiceImpl<WebsiteLinkMapper, WebsiteLink> implements WebsiteLinkService {

    @Override
    public List<WebsiteLinkVO> postWebsiteLinkList() {

        LambdaQueryWrapper<WebsiteLink> websiteLinkLambdaQueryWrapper =
                new QueryWrapper<WebsiteLink>().lambda()
                        .eq(WebsiteLink::getStatusId, ItemStatus.ENABLE.getStatus())
                        .orderByDesc(WebsiteLink::getSort);

        List<WebsiteLink> list = this.list(websiteLinkLambdaQueryWrapper);

        if(CollUtil.isEmpty(list)){
            return null;
        }

        ArrayList<WebsiteLinkVO> websiteLinkVOS = new ArrayList<>();

        list.forEach(websiteLink -> { websiteLinkVOS.add(BeanUtil.copyProperties(websiteLink,WebsiteLinkVO.class)); });

        return websiteLinkVOS;
    }
}
