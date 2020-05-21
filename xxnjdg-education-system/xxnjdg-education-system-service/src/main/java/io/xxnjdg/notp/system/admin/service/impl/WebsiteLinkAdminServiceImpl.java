package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.WebsiteLinkBO;
import io.xxnjdg.notp.system.admin.object.convert.WebsiteLinkMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteLinkDTO;
import io.xxnjdg.notp.system.admin.object.error.WebsiteLinkEnum;
import io.xxnjdg.notp.system.admin.service.WebsiteLinkAdminService;
import io.xxnjdg.notp.system.mapper.WebsiteLinkMapper;
import io.xxnjdg.notp.system.object.persistent.WebsiteLink;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 18:02
 */
@Service
public class WebsiteLinkAdminServiceImpl extends ServiceImpl<WebsiteLinkMapper, WebsiteLink> implements WebsiteLinkAdminService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public PageResult<WebsiteLinkBO> listWebsiteLinkByPage(WebsiteLinkDTO websiteLinkDTO) {
        PageResult<WebsiteLinkBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<WebsiteLink> wrapper = new QueryWrapper<WebsiteLink>()
                .lambda();

        Integer statusId = websiteLinkDTO.getStatusId();
        String linkName = null;

        if (statusId != null){
            wrapper.eq(WebsiteLink::getStatusId,statusId);
        }

        if (StrUtil.isNotBlank(websiteLinkDTO.getLinkName())){
            linkName = websiteLinkDTO.getLinkName();
            wrapper.like(WebsiteLink::getLinkName,linkName);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                websiteLinkDTO.getPageCurrent(), websiteLinkDTO.getPageSize(), count);

        //查询
        List<WebsiteLink> websiteLinkList =
                this.baseMapper.listWebsiteLinkByPage(statusId,linkName,pageObject.getOffset(), pageObject.getSize());

        List<WebsiteLinkBO> websiteLinkBOList = WebsiteLinkMapStruct.INSTANCE.P2B(websiteLinkList);

        return result
                .setCurrentList(websiteLinkBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) websiteLinkList.size());
    }

    @Override
    public Boolean saveWebsiteLink(WebsiteLinkDTO websiteLinkDTO) {
        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();
        WebsiteLink websiteLink = WebsiteLinkMapStruct.INSTANCE.DTP2P(websiteLinkDTO).setId(id);
        boolean save = this.save(websiteLink);
        if (!save){
            throw new BaseException(WebsiteLinkEnum.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean updateWebsiteLinkById(WebsiteLinkDTO websiteLinkDTO) {
        WebsiteLink websiteLink = WebsiteLinkMapStruct.INSTANCE.DTP2P(websiteLinkDTO);
        boolean update = this.updateById(websiteLink);
        if (!update){
            throw new BaseException(WebsiteLinkEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean deleteWebsiteLinkById(WebsiteLinkDTO websiteLinkDTO) {
        boolean remove = this.removeById(websiteLinkDTO.getId());
        if (!remove){
            throw new BaseException(WebsiteLinkEnum.DELETE_ERROR);
        }
        return true;
    }

    @Override
    public WebsiteLinkBO getWebsiteLinkById(WebsiteLinkDTO websiteLinkDTO) {
        WebsiteLink websiteLink = this.getById(websiteLinkDTO.getId());
        if (websiteLink == null){
            throw new BaseException(WebsiteLinkEnum.GET_ERROR);
        }
        return WebsiteLinkMapStruct.INSTANCE.P2B(websiteLink);
    }
}
