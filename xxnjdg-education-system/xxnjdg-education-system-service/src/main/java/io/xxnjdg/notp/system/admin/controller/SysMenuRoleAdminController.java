package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.SysMenuRoleBO;
import io.xxnjdg.notp.system.admin.object.convert.SysMenuRoleMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysMenuRoleDTO;
import io.xxnjdg.notp.system.admin.service.SysMenuRoleAdminService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.ListGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 6:57
 */
@RestController
public class SysMenuRoleAdminController {

    @Autowired
    private SysMenuRoleAdminService sysMenuRoleAdminService;

    @PostMapping("/system/pc/sys/role/list")
    public ResponseResult listSysMenuRole(@RequestBody @Validated(ListGroup.class) SysMenuRoleDTO sysMenuRoleDTO ){
        SysMenuRoleBO result = sysMenuRoleAdminService.listSysMenuRole(sysMenuRoleDTO);
        return ResponseResult.success(SysMenuRoleMapStruct.INSTANCE.B2LV(result));
    }

    @PostMapping("/system/pc/sys/role/save")
    public ResponseResult saveSysMenuRole(@RequestBody @Validated(Insert.class) SysMenuRoleDTO sysMenuRoleDTO ){
        Boolean result = sysMenuRoleAdminService.saveSysMenuRole(sysMenuRoleDTO);
        return ResponseResult.success(result);
    }

}
