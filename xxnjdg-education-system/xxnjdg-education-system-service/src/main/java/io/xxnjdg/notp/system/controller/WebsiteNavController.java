package io.xxnjdg.notp.system.controller;


import cn.hutool.core.bean.BeanUtil;
import io.xxnjdg.notp.system.object.domain.WebsiteNavLevelDo;
import io.xxnjdg.notp.system.object.view.WebsiteNavLevelVo;
import io.xxnjdg.notp.system.service.WebsiteNavService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 站点导航 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@RestController
public class WebsiteNavController {

    private Logger logger = LoggerFactory.getLogger(WebsiteNavController.class);

    @Autowired
    private WebsiteNavService websiteNavService;

    @PostMapping("/system/api/website/nav/list")
    public ResponseResult getWebsiteNavLevelList(){
        List<WebsiteNavLevelVo> websiteNavLevelVos = websiteNavService.getWebsiteNavLevelList();
        return ResponseResult.success(websiteNavLevelVos);
    }

}

