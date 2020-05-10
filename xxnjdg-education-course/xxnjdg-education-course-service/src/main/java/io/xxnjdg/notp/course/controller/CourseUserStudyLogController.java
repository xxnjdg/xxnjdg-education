package io.xxnjdg.notp.course.controller;


import io.xxnjdg.notp.course.object.business.CourseUserStudyLogBO;
import io.xxnjdg.notp.course.object.convert.CourseUserStudyLogMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseUserStudyLogDTO;
import io.xxnjdg.notp.course.object.view.ListCourseUserStudyLogVO;
import io.xxnjdg.notp.course.service.CourseUserStudyLogService;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 课程用户学习日志 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@RestController
public class CourseUserStudyLogController {

    @Autowired
    private CourseUserStudyLogService courseUserStudyLogService;

    @PostMapping(value = "/course/auth/course/user/study/log/list")
    public ResponseResult listCourseUserStudyLogByPage(
            @RequestBody @Validated ListCourseUserStudyLogDTO listCourseUserStudyLogDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        PageResult<CourseUserStudyLogBO> courseUserStudyLogBO = courseUserStudyLogService.listCourseUserStudyLogByPage(listCourseUserStudyLogDTO.setUserNo(userNo));
        List<ListCourseUserStudyLogVO> listCourseUserStudyLogVOS = CourseUserStudyLogMapStruct.INSTANCE.convertB2V(courseUserStudyLogBO.getCurrentList());
        return ResponseResult.success(new PageResult<ListCourseUserStudyLogVO>()
                .setCurrentList(listCourseUserStudyLogVOS)
                .setTotalCount(courseUserStudyLogBO.getTotalCount()));
    }

}

