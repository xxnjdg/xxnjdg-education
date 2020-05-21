package io.xxnjdg.notp.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.system.admin.object.business.WebsiteLinkBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteLinkDTO;
import io.xxnjdg.notp.system.object.persistent.WebsiteLink;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 18:01
 */
public interface WebsiteLinkAdminService extends IService<WebsiteLink> {
    /**
     * 分页查询WebsiteLink列表
     * @param websiteLinkDTO
     * @return
     */
    PageResult<WebsiteLinkBO> listWebsiteLinkByPage(WebsiteLinkDTO websiteLinkDTO);

    /**
     * 插入
     * @param websiteLinkDTO
     * @return
     */
    Boolean saveWebsiteLink(WebsiteLinkDTO websiteLinkDTO);

    /**
     * 更新
     * @param websiteLinkDTO
     * @return
     */
    Boolean updateWebsiteLinkById(WebsiteLinkDTO websiteLinkDTO);

    /**
     * 删除
     * @param websiteLinkDTO
     * @return
     */
    Boolean deleteWebsiteLinkById(WebsiteLinkDTO websiteLinkDTO);

    /**
     * 查询
     * @param websiteLinkDTO
     * @return
     */
    WebsiteLinkBO getWebsiteLinkById(WebsiteLinkDTO websiteLinkDTO);
}
