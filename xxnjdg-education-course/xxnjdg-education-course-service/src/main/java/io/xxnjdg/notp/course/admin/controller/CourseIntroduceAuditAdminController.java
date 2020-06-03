package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.service.CourseIntroduceAuditAdminService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
