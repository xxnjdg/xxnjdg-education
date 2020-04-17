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
        websiteNavs.forEach(websiteNav -> {
            WebsiteNavLevelVo websiteNavLevelVo = new WebsiteNavLevelVo();
            BeanUtil.copyProperties(websiteNav,websiteNavLevelVo);
            websiteNavLevelVos.add(websiteNavLevelVo);
        });

        // 找到父节点
        List<WebsiteNavLevelVo> parentList = websiteNavLevelVos.stream()
                .filter(websiteNavLevelVo -> ParentId.ZERO_PARENT_ID.getStatus().equals(websiteNavLevelVo.getParentId()))
                .collect(Collectors.toList());


        // 设置父节点孩子
        parentList.forEach(websiteNavLevelVo -> {
                    websiteNavLevelVos.forEach(websiteNavLevelVo1 -> {
                        if(websiteNavLevelVo.getId().equals(websiteNavLevelVo1.getParentId())){
                            if(websiteNavLevelVo.getChildren() == null){
                                websiteNavLevelVo.setChildren(new ArrayList<>());
                            }
                            websiteNavLevelVo.getChildren().add(websiteNavLevelVo1);
                        }
                    });
                });

        return parentList;
    }
}
