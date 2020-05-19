package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.WebsiteBO;
import io.xxnjdg.notp.system.admin.object.convert.WebsiteMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteDTO;
import io.xxnjdg.notp.system.admin.service.WebsiteAdminService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 18:48
 */
@RestController
public class WebsiteAdminController {

    @Autowired
    private WebsiteAdminService websiteAdminService;

    @PostMapping("/system/pc/website/view")
    public ResponseResult listWebsite(){
        List<WebsiteBO> result = websiteAdminService.listWebsite();
        return ResponseResult.success(WebsiteMapStruct.INSTANCE.B2V(result));
    }

    // TODO: 2020/5/18 没写校验
    @PostMapping("/system/pc/website/update")
    public ResponseResult updateWebsiteById(@RequestBody WebsiteDTO websiteDTO){
        Boolean result = websiteAdminService.updateWebsiteById(websiteDTO);
        return ResponseResult.success(result);
    }

}
