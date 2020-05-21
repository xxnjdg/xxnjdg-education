package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.WebsiteNavBO;
import io.xxnjdg.notp.system.admin.object.convert.WebsiteNavMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteNavDTO;
import io.xxnjdg.notp.system.admin.service.WebsiteNavAdminService;
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
 * @date 2020/5/20 19:53
 */
@RestController
public class WebsiteNavAdminController {

    @Autowired
    private WebsiteNavAdminService websiteNavAdminService;

    @PostMapping("/system/pc/website/nav/list")
    public ResponseResult listWebsiteNavByPage(@RequestBody @Validated(Page.class) WebsiteNavDTO websiteNavDTO ){
        PageResult<WebsiteNavBO> result = websiteNavAdminService.listWebsiteNavByPage(websiteNavDTO);
        return ResponseResult.success(WebsiteNavMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/system/pc/website/nav/save")
    public ResponseResult saveWebsiteNav(@RequestBody @Validated(Insert.class) WebsiteNavDTO websiteNavDTO ){
        Boolean result = websiteNavAdminService.saveWebsiteNav(websiteNavDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/website/nav/view")
    public ResponseResult getWebsiteNavById(@RequestBody @Validated(Get.class) WebsiteNavDTO websiteNavDTO ){
        WebsiteNavBO result = websiteNavAdminService.getWebsiteNavById(websiteNavDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/website/nav/update")
    public ResponseResult updateWebsiteNavById(@RequestBody @Validated(Update.class) WebsiteNavDTO websiteNavDTO ){
        Boolean result = websiteNavAdminService.updateWebsiteNavById(websiteNavDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/website/nav/delete")
    public ResponseResult deleteWebsiteNavById(@RequestBody @Validated(Delete.class) WebsiteNavDTO websiteNavDTO ){
        Boolean result = websiteNavAdminService.deleteWebsiteNavById(websiteNavDTO);
        return ResponseResult.success(result);
    }

}
