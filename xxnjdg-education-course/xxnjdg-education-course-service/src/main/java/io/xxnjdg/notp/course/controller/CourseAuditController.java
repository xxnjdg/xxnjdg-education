package io.xxnjdg.notp.course.controller;


import io.xxnjdg.notp.course.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.object.convert.CourseAuditMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.CourseAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.CourseAuditPutawayDTO;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseAuditBTO;
import io.xxnjdg.notp.course.object.data.transfer.InsertCourseAuditDTO;
import io.xxnjdg.notp.course.object.view.CourseAuditVO;
import io.xxnjdg.notp.course.object.view.InsertCourseAuditVO;
import io.xxnjdg.notp.course.object.view.ListCourseAuditVO;
import io.xxnjdg.notp.course.service.CourseAuditService;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Insert;
import io.xxnjdg.notp.utils.validator.group.Update;
import io.xxnjdg.notp.utils.validator.group.UpdatePutaway;
import io.xxnjdg.notp.utils.validator.group.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * <p>
 * 课程信息-审核 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@RestController
public class CourseAuditController {

    @Autowired
    private CourseAuditService courseAuditService;

    @PostMapping("/course/auth/course/audit/list")
    public ResponseResult listCourseAuditByPage(
            @RequestBody @Validated ListCourseAuditBTO listCourseAuditBTO ){
        PageResult<CourseAuditBO> boPageResult = courseAuditService.listCourseAuditByPage(listCourseAuditBTO);
        List<ListCourseAuditVO> listCourseAuditVOS = CourseAuditMapStruct.INSTANCE.convertB2V(boPageResult.getCurrentList());
        return ResponseResult.success(new PageResult<ListCourseAuditVO>()
                .setCurrentList(listCourseAuditVOS)
                .setTotalCount(boPageResult.getTotalCount())
                .setTotalPage(boPageResult.getTotalPage())
                .setCurrentPage(boPageResult.getCurrentPage())
                .setCurrentListSize(boPageResult.getCurrentListSize()));
    }

    @PostMapping("/course/auth/course/audit/view")
    public ResponseResult getCourseAudit(
            @RequestBody @Validated(View.class) CourseAuditDTO courseAuditDTO){
        CourseAuditBO courseAuditBO = courseAuditService.getCourseAudit(courseAuditDTO);
        CourseAuditVO courseAuditVO = CourseAuditMapStruct.INSTANCE.mapB2V(courseAuditBO);
        return ResponseResult.success(courseAuditVO);
    }

    @PostMapping("/course/auth/course/audit/save")
    public ResponseResult insertCourseAudit(
            @RequestBody @Validated(Insert.class) CourseAuditDTO courseAuditDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        CourseAuditBO courseAuditBO = courseAuditService.insertCourseAudit(courseAuditDTO.setLecturerUserNo(userNo));
        InsertCourseAuditVO insertCourseAuditVO = CourseAuditMapStruct.INSTANCE.convertB2V(courseAuditBO);
        return ResponseResult.success(insertCourseAuditVO);
    }

    @PostMapping("/course/auth/course/audit/update")
    public ResponseResult updateCourseAudit(
            @RequestBody @Validated(Update.class) CourseAuditDTO courseAuditDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        courseAuditService.updateCourseAudit(courseAuditDTO.setLecturerUserNo(userNo));
        return ResponseResult.success();
    }

    @PostMapping("/course/auth/course/audit/stand")
    public ResponseResult updateCourseAuditByPutaway(
            @RequestBody @Validated(UpdatePutaway.class) CourseAuditDTO courseAuditDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        courseAuditService.updateCourseAuditById(courseAuditDTO.setLecturerUserNo(userNo));
        return ResponseResult.success();
    }

}

