package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.WebsiteNavArticleBO;
import io.xxnjdg.notp.system.admin.object.convert.WebsiteNavArticleMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.WebsiteNavArticleDTO;
import io.xxnjdg.notp.system.admin.service.WebsiteNavArticleAdminService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Get;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 22:57
 */
@RestController
public class WebsiteNavArticleAdminController {
    @Autowired
    private WebsiteNavArticleAdminService websiteNavArticleAdminService;

    @PostMapping("/system/pc/website/nav/article/view")
    public ResponseResult getWebsiteNavArticleByNavId(@RequestBody @Validated(Get.class) WebsiteNavArticleDTO websiteNavArticleDTO ){
        WebsiteNavArticleBO result = websiteNavArticleAdminService.getWebsiteNavArticleByNavId(websiteNavArticleDTO);
        return ResponseResult.success(WebsiteNavArticleMapStruct.INSTANCE.B2V(result));
    }

    @PostMapping("/system/pc/website/nav/article/update")
    public ResponseResult updateWebsiteNavArticleById(@RequestBody @Validated(Update.class) WebsiteNavArticleDTO websiteNavArticleDTO ){
        Boolean result = websiteNavArticleAdminService.updateWebsiteNavArticleById(websiteNavArticleDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/website/nav/article/save")
    public ResponseResult saveWebsiteNavArticle(@RequestBody @Validated(Insert.class) WebsiteNavArticleDTO websiteNavArticleDTO ){
        Boolean result = websiteNavArticleAdminService.saveWebsiteNavArticle(websiteNavArticleDTO);
        return ResponseResult.success(result);
    }
}
