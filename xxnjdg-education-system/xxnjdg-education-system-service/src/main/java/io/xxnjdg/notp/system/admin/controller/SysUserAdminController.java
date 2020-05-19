package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.SysUserBO;
import io.xxnjdg.notp.system.admin.object.convert.SysUserMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.admin.service.SysUserAdminService;
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
 * @date 2020/5/19 2:57
 */
@RestController
public class SysUserAdminController {
    @Autowired
    private SysUserAdminService sysUserAdminService;

    @PostMapping("/system/pc/sys/user/list")
    public ResponseResult listSysUserByPage(@RequestBody @Validated(Page.class) SysUserDTO sysUserDTO ){
        PageResult<SysUserBO> result = sysUserAdminService.listSysUserByPage(sysUserDTO);
        return ResponseResult.success(SysUserMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/system/pc/sys/user/save")
    public ResponseResult saveSysUser(@RequestBody @Validated(Insert.class) SysUserDTO sysUserDTO ){
        Boolean result = sysUserAdminService.saveSysUser(sysUserDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/sys/user/delete")
    public ResponseResult deleteSysUserById(@RequestBody @Validated(Delete.class) SysUserDTO sysUserDTO ){
        Boolean result = sysUserAdminService.deleteSysUserById(sysUserDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/sys/user/update")
    public ResponseResult updateSysUserById(@RequestBody @Validated(Update.class) SysUserDTO sysUserDTO ){
        Boolean result = sysUserAdminService.updateSysUserById(sysUserDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/system/pc/sys/user/view")
    public ResponseResult getSysUserById(@RequestBody @Validated(Get.class) SysUserDTO sysUserDTO ){
        SysUserBO result = sysUserAdminService.getSysUserById(sysUserDTO);
        return ResponseResult.success(SysUserMapStruct.INSTANCE.B2V(result));
    }
}
