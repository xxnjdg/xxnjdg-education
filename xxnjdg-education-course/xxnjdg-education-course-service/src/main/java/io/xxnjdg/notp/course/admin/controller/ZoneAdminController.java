package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.object.business.ZoneBO;
import io.xxnjdg.notp.course.admin.object.convert.ZoneMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.ZoneDTO;
import io.xxnjdg.notp.course.admin.service.ZoneAdminService;
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
 * @date 2020/5/20 21:07
 */
@RestController
public class ZoneAdminController {

    @Autowired
    private ZoneAdminService zoneAdminService;

    @PostMapping("/course/pc/zone/list")
    public ResponseResult listZoneByPage(@RequestBody @Validated(Page.class) ZoneDTO zoneDTO ){
        PageResult<ZoneBO> result = zoneAdminService.listZoneByPage(zoneDTO);
        return ResponseResult.success(ZoneMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/course/pc/zone/save")
    public ResponseResult saveZone(@RequestBody @Validated(Insert.class) ZoneDTO zoneDTO ){
        Boolean result = zoneAdminService.saveZone(zoneDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/zone/update")
    public ResponseResult updateZoneById(@RequestBody @Validated(Update.class) ZoneDTO zoneDTO ){
        Boolean result = zoneAdminService.updateZoneById(zoneDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/zone/delete")
    public ResponseResult deleteZoneById(@RequestBody @Validated(Delete.class) ZoneDTO zoneDTO ){
        Boolean result = zoneAdminService.deleteZoneById(zoneDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/zone/view")
    public ResponseResult getZoneById(@RequestBody @Validated(Get.class) ZoneDTO zoneDTO ){
        ZoneBO result = zoneAdminService.getZoneById(zoneDTO);
        return ResponseResult.success(ZoneMapStruct.INSTANCE.B2V(result));
    }

}
