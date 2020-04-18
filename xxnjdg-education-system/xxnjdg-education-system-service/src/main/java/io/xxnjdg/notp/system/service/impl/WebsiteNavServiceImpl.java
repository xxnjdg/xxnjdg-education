package io.xxnjdg.notp.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.system.object.persistent.WebsiteNav;
import io.xxnjdg.notp.system.mapper.WebsiteNavMapper;
import io.xxnjdg.notp.system.object.view.WebsiteNavLevelVo;
import io.xxnjdg.notp.system.service.WebsiteNavService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.ItemStatus;
import io.xxnjdg.notp.utils.constant.ParentId;
import io.xxnjdg.notp.utils.custom.utils.ListToTreeUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 站点导航 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@Service
public class WebsiteNavServiceImpl extends ServiceImpl<WebsiteNavMapper, WebsiteNav> implements WebsiteNavService {

    @Override
    public List<WebsiteNavLevelVo> getWebsiteNavLevelList() {

        //查询所有项,访问一次database,没有join,内存操作寻找子节点
        List<WebsiteNav> websiteNavs = baseMapper.selectList(
                new QueryWrapper<WebsiteNav>().lambda().eq(WebsiteNav::getStatusId, ItemStatus.ENABLE.getStatus()));

        //结果为空,直接返回
        if (CollUtil.isEmpty(websiteNavs)){
            return null;
        }

        //po -> vo
        ArrayList<WebsiteNavLevelVo> websiteNavLevelVos = new ArrayList<>();
        websiteNavs.forEach(websiteNav -> { websiteNavLevelVos.add(BeanUtil.copyProperties(websiteNav,WebsiteNavLevelVo.class)); });

        List<WebsiteNavLevelVo> tree = null;
        try {
            //构造树结构
            tree = ListToTreeUtil.getTree(websiteNavLevelVos, ParentId.ZERO_PARENT_ID.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tree;
    }
}
