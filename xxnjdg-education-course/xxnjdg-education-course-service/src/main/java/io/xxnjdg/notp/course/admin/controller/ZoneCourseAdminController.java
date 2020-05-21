package io.xxnjdg.notp.course.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import io.xxnjdg.notp.course.admin.object.business.ZoneCourseBO;
import io.xxnjdg.notp.course.admin.object.convert.ZoneCourseMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.ZoneCourseDTO;
import io.xxnjdg.notp.course.admin.service.ZoneCourseAdminService;
import io.xxnjdg.notp.course.object.persistent.ZoneCourse;
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

import java.util.List;
import java.util.Map;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 0:06
 */
@RestController
public class ZoneCourseAdminController {
    @Autowired
    private ZoneCourseAdminService zoneCourseAdminService;

    @PostMapping("/course/pc/zone/course/list")
    public ResponseResult listZoneCourseByPage(@RequestBody @Validated(Page.class) ZoneCourseDTO zoneCourseDTO ){
        PageResult<ZoneCourseBO> result = zoneCourseAdminService.listZoneCourseByPage(zoneCourseDTO);
        return ResponseResult.success(ZoneCourseMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/course/pc/zone/course/save")
    public ResponseResult saveZoneCourse(@RequestBody @Validated(Insert.class) ZoneCourseDTO zoneCourseDTO ){
        Boolean result = zoneCourseAdminService.saveZoneCourse(zoneCourseDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/zone/course/update")
    public ResponseResult updateZoneCourseById(@RequestBody @Validated(Update.class) ZoneCourseDTO zoneCourseDTO ){
        Boolean result = zoneCourseAdminService.updateZoneCourseById(zoneCourseDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/zone/course/delete")
    public ResponseResult deleteZoneCourseById(@RequestBody @Validated(Delete.class) ZoneCourseDTO zoneCourseDTO ){
        Boolean result = zoneCourseAdminService.deleteZoneCourseById(zoneCourseDTO);
        return ResponseResult.success(result);
    }

}
