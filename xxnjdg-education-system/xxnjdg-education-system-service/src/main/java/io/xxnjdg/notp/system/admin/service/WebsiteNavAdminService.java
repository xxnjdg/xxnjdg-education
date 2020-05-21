package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.WebsiteNavBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteNavDTO;
import io.xxnjdg.notp.system.object.persistent.WebsiteNav;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 19:54
 */
public interface WebsiteNavAdminService extends IService<WebsiteNav> {
    /**
     * 分页查询tWebsiteNav列表
     * @param websiteNavDTO
     * @return
     */
    PageResult<WebsiteNavBO> listWebsiteNavByPage(WebsiteNavDTO websiteNavDTO);

    /**
     * 插入
     * @param websiteNavDTO
     * @return
     */
    Boolean saveWebsiteNav(WebsiteNavDTO websiteNavDTO);

    /**
     * 查询
     * @param websiteNavDTO
     * @return
     */
    WebsiteNavBO getWebsiteNavById(WebsiteNavDTO websiteNavDTO);

    /**
     * 更新
     * @param websiteNavDTO
     * @return
     */
    Boolean updateWebsiteNavById(WebsiteNavDTO websiteNavDTO);

    /**
     * 删除
     * @param websiteNavDTO
     * @return
     */
    Boolean deleteWebsiteNavById(WebsiteNavDTO websiteNavDTO);
}
