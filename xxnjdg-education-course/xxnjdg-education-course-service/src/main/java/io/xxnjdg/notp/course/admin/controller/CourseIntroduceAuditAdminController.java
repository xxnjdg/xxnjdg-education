package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.service.CourseIntroduceAuditAdminService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 12:38
 */
@RestController
public class CourseIntroduceAuditAdminController {
    @Autowired
    private CourseIntroduceAuditAdminService courseIntroduceAuditAdminService;

//    @PostMapping("/course/pc/course/user/study/log/list")
//    public ResponseResult listCourseCategoryByPage(@RequestBody @Validated(Page.class) CourseCategoryDTO courseCategoryDTO ){
//        PageResult<CourseCategoryBO> result = courseIntroduceAuditAdminService.listCourseCategoryByPage(courseCategoryDTO);
//        return ResponseResult.success(CourseCategoryMapStruct.INSTANCE.B2PV(result));
//    }
}
