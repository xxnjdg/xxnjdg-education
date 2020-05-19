package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.SysMenuBO;
import io.xxnjdg.notp.system.admin.object.convert.SysMenuMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysMenuDTO;
import io.xxnjdg.notp.system.admin.service.SysMenuAdminService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 22:03
 */
@RestController("new-SysMenuAdminController")
public class SysMenuAdminController {
    @Autowired
    private SysMenuAdminService sysMenuAdminService;

    @PostMapping("/system/pc/menu/list")
    public ResponseResult listSysMenu(@RequestBody @Validated(ListGroup.class) SysMenuDTO sysMenuDTO ){
        List<SysMenuBO> result = sysMenuAdminService.listSysMenu(sysMenuDTO);
        return ResponseResult.success(SysMenuMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/system/pc/menu/save")
    public ResponseResult saveSysMenu(@RequestBody @Validated(Insert.class) SysMenuDTO sysMenuDTO ){
        Boolean result = sysMenuAdminService.saveSysMenu(sysMenuDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/menu/delete")
    public ResponseResult deleteSysMenuById(@RequestBody @Validated(Delete.class) SysMenuDTO sysMenuDTO ){
        Boolean result = sysMenuAdminService.deleteSysMenuById(sysMenuDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/menu/update")
    public ResponseResult updateSysMenuById(@RequestBody @Validated(Update.class) SysMenuDTO sysMenuDTO ){
        Boolean result = sysMenuAdminService.updateSysMenuById(sysMenuDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/menu/view")
    public ResponseResult getSysMenuById(@RequestBody @Validated(Get.class) SysMenuDTO sysMenuDTO ){
        SysMenuBO result = sysMenuAdminService.getSysMenuById(sysMenuDTO);
        return ResponseResult.success(SysMenuMapStruct.INSTANCE.B2V(result));
    }
}
