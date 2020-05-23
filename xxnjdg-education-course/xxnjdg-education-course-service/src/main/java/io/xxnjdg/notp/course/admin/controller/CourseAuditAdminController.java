package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseAuditMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseAuditDTO;
import io.xxnjdg.notp.course.admin.service.CourseAuditAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Get;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.Page;
import io.xxnjdg.notp.utils.validator.group.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 23:16
 */
@RestController
public class CourseAuditAdminController {

    @Autowired
    private CourseAuditAdminService courseAuditAdminService;

    @PostMapping("/course/pc/course/audit/list")
    public ResponseResult listCourseAuditByPage(@RequestBody @Validated(Page.class) CourseAuditDTO courseAuditDTO ){
        PageResult<CourseAuditBO> result = courseAuditAdminService.listCourseAuditByPage(courseAuditDTO);
        return ResponseResult.success(CourseAuditMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/course/pc/course/audit/update")
    public ResponseResult updateCourseAuditById(@RequestBody @Validated(Insert.class) CourseAuditDTO courseAuditDTO ){
        Boolean result = courseAuditAdminService.updateCourseAudit(courseAuditDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/course/audit/audit")
    public ResponseResult auditCourseAudit(@RequestBody @Validated(View.class) CourseAuditDTO courseAuditDTO ){
        Boolean result = courseAuditAdminService.auditCourseAudit(courseAuditDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/course/pc/course/audit/view")
    public ResponseResult getCourseAuditById(@RequestBody @Validated(Get.class) CourseAuditDTO courseAuditDTO ){
        CourseAuditBO result = courseAuditAdminService.getCourseAuditById(courseAuditDTO);
        return ResponseResult.success(result);
    }

}
