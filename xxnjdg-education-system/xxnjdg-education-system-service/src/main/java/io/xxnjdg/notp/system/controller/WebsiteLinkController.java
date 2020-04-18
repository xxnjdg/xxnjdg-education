package io.xxnjdg.notp.system.controller;


import io.xxnjdg.notp.system.object.view.WebsiteLinkVO;
import io.xxnjdg.notp.system.service.WebsiteLinkService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 站点友情链接 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@RestController
public class WebsiteLinkController {

    @Autowired
    private WebsiteLinkService websiteLinkService;

    @PostMapping("/system/api/website/link")
    public ResponseResult postWebsiteLinkList(){
        List<WebsiteLinkVO> websiteLinkVOS =  websiteLinkService.postWebsiteLinkList();
        return ResponseResult.success(websiteLinkVOS);
    }

}

