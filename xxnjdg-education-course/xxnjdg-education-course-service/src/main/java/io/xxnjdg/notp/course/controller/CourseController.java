package io.xxnjdg.notp.course.controller;


import io.xxnjdg.notp.course.object.business.CourseDetailBO;
import io.xxnjdg.notp.course.object.convert.CourseDetailBOToVO;
import io.xxnjdg.notp.course.object.data.transfer.CourseDetailDTO;
import io.xxnjdg.notp.course.object.data.transfer.CourseListDTO;
import io.xxnjdg.notp.course.object.view.CourseDetailVO;
import io.xxnjdg.notp.course.object.view.CourseListVO;
import io.xxnjdg.notp.course.service.CourseService;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 课程信息 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@RestController
@Validated
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/course/api/course/list")
    public ResponseResult postCourseListByPage(@RequestBody @Validated CourseListDTO courseListDTO){
        PageResult<CourseListVO> pageResult = courseService.postCourseListByPage(courseListDTO);
        return ResponseResult.success(pageResult);
    }

    @PostMapping("/course/api/course/view")
    public ResponseResult getNoLoginCourseDetail(@RequestBody @Validated CourseDetailDTO courseDetailDTO){
        CourseDetailBO courseDetailBO = courseService.getCourseDetail(courseDetailDTO.setUserNo(null));
        CourseDetailVO courseDetailVO = CourseDetailBOToVO.INSTANCE.convert(courseDetailBO);
        return ResponseResult.success(courseDetailVO);
    }

    @PostMapping("/course/auth/course/view")
    public ResponseResult getCourseDetail(
            @RequestBody @Validated CourseDetailDTO courseDetailDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        CourseDetailBO courseDetailBO = courseService.getCourseDetail(courseDetailDTO.setUserNo(userNo));
        CourseDetailVO courseDetailVO = CourseDetailBOToVO.INSTANCE.convert(courseDetailBO);
        return ResponseResult.success(courseDetailVO);
    }

}

