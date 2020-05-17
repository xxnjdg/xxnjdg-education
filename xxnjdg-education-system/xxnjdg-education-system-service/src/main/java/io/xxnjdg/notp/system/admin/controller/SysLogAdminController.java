package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.SysLogBO;
import io.xxnjdg.notp.system.admin.object.convert.SysLogMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysLogDTO;
import io.xxnjdg.notp.system.admin.service.SysLogAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 21:31
 */
@RestController
public class SysLogAdminController {

    @Autowired
    private SysLogAdminService sysLogAdminService;

    @PostMapping("/system/pc/sys/log/list")
    public ResponseResult listSysLogByPage(@RequestBody @Validated SysLogDTO sysLogDTO ){
        PageResult<SysLogBO> result = sysLogAdminService.listSysLogByPage(sysLogDTO);
        return ResponseResult.success(SysLogMapStruct.INSTANCE.B2V(result));
    }
}
