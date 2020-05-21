package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.WebsiteLinkBO;
import io.xxnjdg.notp.system.admin.object.convert.WebsiteLinkMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteLinkDTO;
import io.xxnjdg.notp.system.admin.service.WebsiteLinkAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 18:01
 */
@RestController
public class WebsiteLinkAdminController {
    @Autowired
    private WebsiteLinkAdminService websiteLinkAdminService;

    @PostMapping("/system/pc/website/link/list")
    public ResponseResult listWebsiteLinkByPage(@RequestBody @Validated(Page.class) WebsiteLinkDTO websiteLinkDTO ){
        PageResult<WebsiteLinkBO> result = websiteLinkAdminService.listWebsiteLinkByPage(websiteLinkDTO);
        return ResponseResult.success(WebsiteLinkMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/system/pc/website/link/save")
    public ResponseResult saveWebsiteLink(@RequestBody @Validated(Insert.class) WebsiteLinkDTO websiteLinkDTO ){
        Boolean result = websiteLinkAdminService.saveWebsiteLink(websiteLinkDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/website/link/update")
    public ResponseResult updateWebsiteLinkById(@RequestBody @Validated(Update.class) WebsiteLinkDTO websiteLinkDTO ){
        Boolean result = websiteLinkAdminService.updateWebsiteLinkById(websiteLinkDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/website/link/delete")
    public ResponseResult deleteWebsiteLinkById(@RequestBody @Validated(Delete.class) WebsiteLinkDTO websiteLinkDTO ){
        Boolean result = websiteLinkAdminService.deleteWebsiteLinkById(websiteLinkDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/website/link/view")
    public ResponseResult getWebsiteLinkById(@RequestBody @Validated(Get.class) WebsiteLinkDTO websiteLinkDTO ){
        WebsiteLinkBO result = websiteLinkAdminService.getWebsiteLinkById(websiteLinkDTO);
        return ResponseResult.success(WebsiteLinkMapStruct.INSTANCE.B2V(result));
    }

}
