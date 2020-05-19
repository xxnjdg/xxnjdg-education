package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.SysRoleUserBO;
import io.xxnjdg.notp.system.admin.object.convert.SysRoleUserMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysRoleUserDTO;
import io.xxnjdg.notp.system.admin.service.SysRoleUserAdminService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/19 14:59
 */
@RestController
public class SysRoleUserAdminController {
    @Autowired
    private SysRoleUserAdminService sysRoleUserAdminService;

    @PostMapping("/system/pc/sys/role/user/save")
    public ResponseResult saveSysRoleUser(@RequestBody @Validated(Insert.class) SysRoleUserDTO sysRoleUserDTO ){
        Boolean result = sysRoleUserAdminService.saveSysRoleUser(sysRoleUserDTO);
        return ResponseResult.success(result);
    }
}
