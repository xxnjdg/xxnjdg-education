package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.object.business.CourseUserStudyLogBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseUserStudyLogMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseUserStudyLogDTO;
import io.xxnjdg.notp.course.admin.service.CourseUserStudyLogAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
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
 * @date 2020/5/26 4:10
 */
@RestController
public class CourseUserStudyLogAdminController {
    @Autowired
    private CourseUserStudyLogAdminService courseUserStudyLogAdminService;


    @PostMapping("/course/pc/course/user/study/log/list")
    public ResponseResult listCourseUserStudyLogByPage(@RequestBody @Validated(Page.class) CourseUserStudyLogDTO courseUserStudyLogDTO ){
        PageResult<CourseUserStudyLogBO> result = courseUserStudyLogAdminService.listCourseUserStudyLogByPage(courseUserStudyLogDTO);
        return ResponseResult.success(CourseUserStudyLogMapStruct.INSTANCE.B2PV(result));
    }
}
