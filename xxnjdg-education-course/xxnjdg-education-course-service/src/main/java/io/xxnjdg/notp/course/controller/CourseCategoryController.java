package io.xxnjdg.notp.course.controller;


import cn.hutool.core.collection.CollUtil;
import io.xxnjdg.notp.course.object.view.CourseCategoryLevelVo;
import io.xxnjdg.notp.course.service.CourseCategoryService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程分类 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@RestController
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    @PostMapping("/course/api/course/category/list")
    public ResponseResult postCourseCategoryList(){
        List<CourseCategoryLevelVo> courseCategoryLevelVos = courseCategoryService.postCourseCategoryList();
        return ResponseResult.success(courseCategoryLevelVos);
    }

}

