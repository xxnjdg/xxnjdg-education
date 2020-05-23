package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.object.business.CourseBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseDTO;
import io.xxnjdg.notp.course.admin.service.CourseAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Get;
import io.xxnjdg.notp.utils.validator.group.Page;
import io.xxnjdg.notp.utils.validator.group.Update;
import io.xxnjdg.notp.utils.validator.group.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 22:51
 */
@RestController
public class CourseAdminController {

    @Autowired
    private CourseAdminService courseAdminService;

    @PostMapping("/course/pc/course/list")
    public ResponseResult listCourseByPage(@RequestBody @Validated(Page.class) CourseDTO courseDTO ){
        PageResult<CourseBO> result = courseAdminService.listCourseByPage(courseDTO);
        return ResponseResult.success(CourseMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/course/pc/course/update")
    public ResponseResult updateCourse(@RequestBody @Validated(Update.class) CourseDTO courseDTO ){
        Boolean result = courseAdminService.updateCourse(courseDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/course/view")
    public ResponseResult viewCourse(@RequestBody @Validated(View.class) CourseDTO courseDTO ){
        CourseBO result = courseAdminService.viewCourse(courseDTO);
        // TODO: 2020/5/23 转换没写完
        return ResponseResult.success(CourseMapStruct.INSTANCE.B2VV(result));
    }

    @PostMapping("/course/pc/course/get")
    public ResponseResult getCourse(@RequestBody @Validated(Get.class) CourseDTO courseDTO ){
        CourseBO result = courseAdminService.getCourse(courseDTO);
        return ResponseResult.success(CourseMapStruct.INSTANCE.B2GV(result));
    }

}
