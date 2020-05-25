package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseCategoryMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseCategoryDTO;
import io.xxnjdg.notp.course.admin.service.CourseCategoryAdminService;
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
 * @date 2020/5/23 21:31
 */
@RestController
public class CourseCategoryAdminController {
    @Autowired
    private CourseCategoryAdminService courseCategoryAdminService;

    @PostMapping("/course/pc/course/category/list")
    public ResponseResult listCourseCategoryByPage(@RequestBody @Validated(Page.class) CourseCategoryDTO courseCategoryDTO ){
        PageResult<CourseCategoryBO> result = courseCategoryAdminService.listCourseCategoryByPage(courseCategoryDTO);
        return ResponseResult.success(CourseCategoryMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/course/pc/course/category/save")
    public ResponseResult saveCourseCategory(@RequestBody @Validated(Insert.class) CourseCategoryDTO courseCategoryDTO ){
        Boolean result = courseCategoryAdminService.saveCourseCategory(courseCategoryDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/course/category/update")
    public ResponseResult updateCourseCategory(@RequestBody @Validated(Update.class) CourseCategoryDTO courseCategoryDTO ){
        Boolean result = courseCategoryAdminService.updateCourseCategory(courseCategoryDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/course/category/delete")
    public ResponseResult deleteCourseCategory(@RequestBody @Validated(Delete.class) CourseCategoryDTO courseCategoryDTO ){
        Boolean result = courseCategoryAdminService.deleteCourseCategory(courseCategoryDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/course/category/update")
    public ResponseResult getCourseCategory(@RequestBody @Validated(Get.class) CourseCategoryDTO courseCategoryDTO ){
        CourseCategoryBO result = courseCategoryAdminService.getCourseCategory(courseCategoryDTO);
        return ResponseResult.success(CourseCategoryMapStruct.INSTANCE.B2V(result));
    }
}
