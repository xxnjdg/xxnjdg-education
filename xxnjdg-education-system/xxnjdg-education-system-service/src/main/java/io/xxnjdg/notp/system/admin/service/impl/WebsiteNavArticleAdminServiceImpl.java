package io.xxnjdg.notp.system.admin.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.WebsiteNavArticleBO;
import io.xxnjdg.notp.system.admin.object.convert.WebsiteNavArticleMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteNavArticleDTO;
import io.xxnjdg.notp.system.admin.object.error.WebsiteNavArticleEnum;
import io.xxnjdg.notp.system.admin.service.WebsiteNavArticleAdminService;
import io.xxnjdg.notp.system.mapper.WebsiteNavArticleMapper;
import io.xxnjdg.notp.system.object.persistent.WebsiteNavArticle;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 22:58
 */
@Service
public class WebsiteNavArticleAdminServiceImpl extends ServiceImpl<WebsiteNavArticleMapper, WebsiteNavArticle> implements WebsiteNavArticleAdminService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public List<WebsiteNavArticleBO> listWebsiteNavArticle() {
        return WebsiteNavArticleMapStruct.INSTANCE.P2B(this.list());
    }

    @Override
    public WebsiteNavArticleBO getWebsiteNavArticleByNavId(WebsiteNavArticleDTO websiteNavArticleDTO) {
        LambdaQueryWrapper<WebsiteNavArticle> wrapper = new QueryWrapper<WebsiteNavArticle>()
                .lambda()
                .eq(WebsiteNavArticle::getNavId, websiteNavArticleDTO.getNavId());

        WebsiteNavArticle one = this.getOne(wrapper);
        if (one == null){
            throw new BaseException(WebsiteNavArticleEnum.GET_ERROR);
        }
        return WebsiteNavArticleMapStruct.INSTANCE.P2B(one);
    }

    @Override
    public Boolean updateWebsiteNavArticleById(WebsiteNavArticleDTO websiteNavArticleDTO) {
        WebsiteNavArticle websiteNavArticle = WebsiteNavArticleMapStruct.INSTANCE.DT2P(websiteNavArticleDTO);
        boolean update = this.updateById(websiteNavArticle);
        if (!update){
            throw new BaseException(WebsiteNavArticleEnum.UPDATE_ERROR);
        }
        return true;
    }

    @Override
    public Boolean saveWebsiteNavArticle(WebsiteNavArticleDTO websiteNavArticleDTO) {
        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        WebsiteNavArticle websiteNavArticle = WebsiteNavArticleMapStruct
                .INSTANCE.DT2P(websiteNavArticleDTO).setId(id);

        boolean save = this.save(websiteNavArticle);
        if (!save){
            throw new BaseException(WebsiteNavArticleEnum.UPDATE_ERROR);
        }
        return true;
    }
}
