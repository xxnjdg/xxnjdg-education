package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.NavBarBO;
import io.xxnjdg.notp.system.admin.object.convert.NavBarMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.NavBarDTO;
import io.xxnjdg.notp.system.admin.service.NavBarAdminService;
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
 * @date 2020/5/20 16:02
 */
@RestController
public class NavBarAdminController {
    @Autowired
    private NavBarAdminService navBarAdminService;


    @PostMapping("/system/pc/nav/bar/list")
    public ResponseResult listNavBarByPage(@RequestBody @Validated(Page.class) NavBarDTO navBarDTO ){
        PageResult<NavBarBO> result = navBarAdminService.listNavBarByPage(navBarDTO);
        return ResponseResult.success(NavBarMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/system/pc/nav/bar/save")
    public ResponseResult saveNavBar(@RequestBody @Validated(Insert.class) NavBarDTO navBarDTO ){
        Boolean result = navBarAdminService.saveNavBar(navBarDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/nav/bar//update")
    public ResponseResult updateNavBarById(@RequestBody @Validated(Update.class) NavBarDTO navBarDTO ){
        Boolean result = navBarAdminService.updateNavBarById(navBarDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/nav/bar//delete")
    public ResponseResult deleteNavBarById(@RequestBody @Validated(Delete.class) NavBarDTO navBarDTO ){
        Boolean result = navBarAdminService.deleteNavBarById(navBarDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/nav/bar//view")
    public ResponseResult getNavBarById(@RequestBody @Validated(Get.class) NavBarDTO navBarDTO ){
        NavBarBO result = navBarAdminService.getNavBarById(navBarDTO);
        return ResponseResult.success(NavBarMapStruct.INSTANCE.B2V(result));
    }

}
