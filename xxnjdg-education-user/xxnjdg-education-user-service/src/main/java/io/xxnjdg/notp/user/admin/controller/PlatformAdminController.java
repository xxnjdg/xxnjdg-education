package io.xxnjdg.notp.user.admin.controller;

import io.xxnjdg.notp.user.admin.object.business.PlatformBO;
import io.xxnjdg.notp.user.admin.object.convert.PlatformMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.PlatformDTO;
import io.xxnjdg.notp.user.admin.service.PlatformAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Delete;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.Page;
import io.xxnjdg.notp.utils.validator.group.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/18 21:43
 */
@RestController
public class PlatformAdminController {

    @Autowired
    private PlatformAdminService platformAdminService;

    @PostMapping("/user/pc/platform/list")
    public ResponseResult listPlatformByPage(@RequestBody @Validated(Page.class) PlatformDTO platformDTO ){
        PageResult<PlatformBO> result = platformAdminService.listPlatformByPage(platformDTO);
        return ResponseResult.success(PlatformMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/user/pc/platform/save")
    public ResponseResult savePlatform(@RequestBody @Validated(Insert.class) PlatformDTO platformDTO ){
        Boolean result = platformAdminService.savePlatform(platformDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/user/pc/platform/update")
    public ResponseResult updatePlatformById(@RequestBody @Validated(Update.class) PlatformDTO platformDTO ){
        Boolean result = platformAdminService.updatePlatformById(platformDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/user/pc/platform/delete")
    public ResponseResult deletePlatformById(@RequestBody @Validated(Delete.class) PlatformDTO platformDTO ){
        Boolean result = platformAdminService.deletePlatformById(platformDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/user/pc/platform/get")
    public ResponseResult getPlatformById(@RequestBody @Validated(Delete.class) PlatformDTO platformDTO ){
        PlatformBO result = platformAdminService.getPlatformById(platformDTO);
        return ResponseResult.success(PlatformMapStruct.INSTANCE.B2V(result));
    }

}
