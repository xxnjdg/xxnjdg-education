package io.xxnjdg.notp.system.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.system.admin.object.business.WebsiteBO;
import io.xxnjdg.notp.system.admin.object.convert.WebsiteMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteDTO;
import io.xxnjdg.notp.system.admin.object.error.WebsiteEnum;
import io.xxnjdg.notp.system.admin.service.WebsiteAdminService;
import io.xxnjdg.notp.system.mapper.WebsiteMapper;
import io.xxnjdg.notp.system.object.persistent.Website;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 18:49
 */
@Service
public class WebsiteAdminServiceImpl extends ServiceImpl<WebsiteMapper, Website> implements WebsiteAdminService {
    @Override
    public List<WebsiteBO> listWebsite() {
        return WebsiteMapStruct.INSTANCE.P2B(this.list());
    }

    @Override
    public Boolean updateWebsiteById(WebsiteDTO websiteDTO) {
        Website website = WebsiteMapStruct.INSTANCE.DTO2P(websiteDTO);
        boolean update = this.updateById(website);
        if (!update){
            throw new BaseException(WebsiteEnum.UPDATE_ERROR);
        }
        return true;
    }
}
