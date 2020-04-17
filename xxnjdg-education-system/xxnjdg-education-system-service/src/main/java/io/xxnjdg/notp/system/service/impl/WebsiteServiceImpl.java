package io.xxnjdg.notp.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.object.persistent.Website;
import io.xxnjdg.notp.system.mapper.WebsiteMapper;
import io.xxnjdg.notp.system.object.view.WebsiteVo;
import io.xxnjdg.notp.system.service.WebsiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.ItemStatus;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 站点信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class WebsiteServiceImpl extends ServiceImpl<WebsiteMapper, Website> implements WebsiteService {

    @Override
    public WebsiteVo postWebsite() {
        Website one = this.getOne(new QueryWrapper<Website>().lambda().eq(Website::getStatusId, ItemStatus.ENABLE.getStatus()));
        WebsiteVo websiteVo = new WebsiteVo();
        BeanUtil.copyProperties(one,websiteVo);
        return websiteVo;
    }
}
