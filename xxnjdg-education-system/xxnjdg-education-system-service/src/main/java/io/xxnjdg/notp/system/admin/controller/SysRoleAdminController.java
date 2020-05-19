package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.SysRoleBO;
import io.xxnjdg.notp.system.admin.object.convert.SysRoleMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysRoleDTO;
import io.xxnjdg.notp.system.admin.service.SysRoleAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
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
 * @date 2020/5/19 15:40
 */
@RestController
public class SysRoleAdminController {

    @Autowired
    private SysRoleAdminService sysRoleAdminService;

    @PostMapping("/system/pc/sys/role/list")
    public ResponseResult listSysRoleByPage(@RequestBody @Validated(Page.class) SysRoleDTO sysRoleDTO ){
        PageResult<SysRoleBO> result = sysRoleAdminService.listSysRoleByPage(sysRoleDTO);
        return ResponseResult.success(SysRoleMapStruct.INSTANCE.B2PV(result));
    }
    @PostMapping("/system/pc/sys/role/save")
    public ResponseResult saveSysRole(@RequestBody @Validated(Insert.class) SysRoleDTO sysRoleDTO ){
        Boolean result = sysRoleAdminService.saveSysRole(sysRoleDTO);
        return ResponseResult.success(result);
    }
    @PostMapping("/system/pc/sys/role/update")
    public ResponseResult updateSysRoleById(@RequestBody @Validated(Update.class) SysRoleDTO sysRoleDTO ){
        Boolean result = sysRoleAdminService.updateSysRoleById(sysRoleDTO);
        return ResponseResult.success(result);
    }
    @PostMapping("/system/pc/sys/role/view")
    public ResponseResult getSysRoleById(@RequestBody @Validated(Get.class) SysRoleDTO sysRoleDTO ){
        SysRoleBO sysRoleBO = sysRoleAdminService.getSysRoleById(sysRoleDTO);
        return ResponseResult.success(SysRoleMapStruct.INSTANCE.B2V(sysRoleBO));
    }

    @PostMapping("/system/pc/sys/role/user/list")
    public ResponseResult listSysRoleByUserId(@RequestBody @Validated(ListGroup.class) SysRoleDTO sysRoleDTO ){
        List<SysRoleBO> result = sysRoleAdminService.listSysRoleByUserId(sysRoleDTO);
        return ResponseResult.success(SysRoleMapStruct.INSTANCE.B2V(result));
    }

}
