package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.object.business.AdvBO;
import io.xxnjdg.notp.course.admin.object.convert.AdvMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.AdvDTO;
import io.xxnjdg.notp.course.admin.service.AdvAdminService;
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
 * @date 2020/5/20 13:49
 */
@RestController
public class AdvAdminController {

    @Autowired
    private AdvAdminService advAdminService;

    @PostMapping("/course/pc/adv/list")
    public ResponseResult listAdvByPage(@RequestBody @Validated(Page.class) AdvDTO advDTO ){
        PageResult<AdvBO> result = advAdminService.listAdvByPage(advDTO);
        return ResponseResult.success(AdvMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/course/pc/adv/save")
    public ResponseResult saveAdv(@RequestBody @Validated(Insert.class) AdvDTO advDTO ){
        Boolean result = advAdminService.saveAdv(advDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/adv/view")
    public ResponseResult getAdvById(@RequestBody @Validated(Get.class) AdvDTO advDTO ){
        AdvBO result = advAdminService.getAdvById(advDTO);
        return ResponseResult.success(AdvMapStruct.INSTANCE.B2V(result));
    }

    @PostMapping("/course/pc/adv/update")
    public ResponseResult updateAdvById(@RequestBody @Validated(Update.class) AdvDTO advDTO ){
        Boolean result = advAdminService.updateAdvById(advDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/adv/delete")
    public ResponseResult deleteAdvById(@RequestBody @Validated(Delete.class) AdvDTO advDTO ){
        Boolean result = advAdminService.deleteAdvById(advDTO);
        return ResponseResult.success(result);
    }

}
