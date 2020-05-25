package io.xxnjdg.notp.course.admin.controller;

import io.xxnjdg.notp.course.admin.service.CourseUserStudyLogAdminService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
