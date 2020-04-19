package io.xxnjdg.notp.course.controller;


import io.xxnjdg.notp.course.object.data.transfer.CourseListDTO;
import io.xxnjdg.notp.course.object.view.CourseListVO;
import io.xxnjdg.notp.course.service.CourseService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 课程信息 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/course/api/course/list")
    public ResponseResult postCourseListByPage(@RequestBody @Validated CourseListDTO courseListDTO){
        PageResult<CourseListVO> pageResult = courseService.postCourseListByPage(courseListDTO);
        return ResponseResult.success(pageResult);
    }

}

