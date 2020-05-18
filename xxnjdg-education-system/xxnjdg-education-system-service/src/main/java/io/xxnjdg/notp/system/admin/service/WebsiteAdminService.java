package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.WebsiteBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteDTO;
import io.xxnjdg.notp.system.object.persistent.Website;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 18:48
 */
public interface WebsiteAdminService extends IService<Website> {
    /**
     * 查询Website列表
     * @return
     */
    List<WebsiteBO> listWebsite();

    /**
     * 更新Website
     * @param websiteDTO
     * @return
     */
    Boolean updateWebsiteById(WebsiteDTO websiteDTO);
}
