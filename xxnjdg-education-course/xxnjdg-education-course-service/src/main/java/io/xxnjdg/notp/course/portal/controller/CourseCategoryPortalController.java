package io.xxnjdg.notp.course.portal.controller;

import io.xxnjdg.notp.course.portal.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.portal.object.convert.CourseCategoryMapStruct;
import io.xxnjdg.notp.course.portal.service.CourseCategoryPortalService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 18:49
 */
@RestController
public class CourseCategoryPortalController {

    @Autowired
    private CourseCategoryPortalService courseCategoryPortalService;

    @PostMapping("/course/api/course/category/list")
    public ResponseResult listCourseCategory(){
        List<CourseCategoryBO> result = courseCategoryPortalService.listCourseCategory();
        return ResponseResult.success(CourseCategoryMapStruct.INSTANCE.B2PV(result));
    }
}
