package io.xxnjdg.notp.system.controller;


import io.xxnjdg.notp.system.object.persistent.NavBar;
import io.xxnjdg.notp.system.service.NavBarService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 头部导航 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@RestController
public class NavBarController {

    @Autowired
    private NavBarService navBarService;

    @PostMapping("/system/api/nav/bar/list")
    public ResponseResult getNavBarList(){
        List<NavBar> list = navBarService.getNavBarList();
        return ResponseResult.success(list);
    }

}

