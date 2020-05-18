package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.business.SysBO;
import io.xxnjdg.notp.system.admin.object.convert.SysMapStruct;
import io.xxnjdg.notp.system.admin.object.data.transfer.SysDTO;
import io.xxnjdg.notp.system.admin.service.SysAdminService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 20:50
 */
@RestController
public class SysAdminController {

    @Autowired
    private SysAdminService sysAdminService;

    @PostMapping("/system/pc/sys/view")
    public ResponseResult listSys(){
        List<SysBO> result = sysAdminService.listSys();
        return ResponseResult.success(SysMapStruct.INSTANCE.B2V(result));
    }

    // TODO: 2020/5/18 没写校验
    @PostMapping("/system/pc/sys/update")
    public ResponseResult updateSysById(@RequestBody @Validated SysDTO sysDTO ){
        Boolean result = sysAdminService.updateSysById(sysDTO);
        return ResponseResult.success(result);
    }

}
