package io.xxnjdg.notp.system.controller;


import io.xxnjdg.notp.system.object.view.WebsiteVo;
import io.xxnjdg.notp.system.service.WebsiteService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 站点信息 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@RestController
public class WebsiteController {

    @Autowired
    private WebsiteService websiteService;

    @PostMapping("/system/api/website/get")
    public ResponseResult postWebsite(){
        WebsiteVo websiteVo = websiteService.postWebsite();
        return ResponseResult.success(websiteVo);
    }

}

