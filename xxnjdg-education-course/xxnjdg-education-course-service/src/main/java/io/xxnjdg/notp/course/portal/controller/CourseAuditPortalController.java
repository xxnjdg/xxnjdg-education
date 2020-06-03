package io.xxnjdg.notp.course.portal.controller;

import io.xxnjdg.notp.course.portal.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.portal.object.convert.CourseAuditMapStruct;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.autdit.*;
import io.xxnjdg.notp.course.portal.service.CourseAuditPortalService;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/27 4:03
 */
@RestController
@Validated
public class CourseAuditPortalController {

    @Autowired
    private CourseAuditPortalService courseAuditPortalService;

    @PostMapping("/course/auth/course/audit/list")
    public ResponseResult listCourseAuditByPage(@RequestBody @Validated CourseAuditPageDTO courseAuditPageDTO ){
        PageResult<CourseAuditBO> result = courseAuditPortalService.listCourseAuditByPage(courseAuditPageDTO);
        return ResponseResult.success(CourseAuditMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/course/auth/course/audit/view")
    public ResponseResult getCourseAudit(@RequestBody @Validated CourseAuditViewDTO courseAuditViewDTO){
        CourseAuditBO result = courseAuditPortalService.getCourseAudit(courseAuditViewDTO);
        return ResponseResult.success(CourseAuditMapStruct.INSTANCE.B2VV(result));
    }

    @PostMapping("/course/auth/course/audit/save")
    public ResponseResult saveCourseAudit(
            @RequestBody @Validated CourseAuditSaveDTO courseAuditSaveDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        CourseAuditBO result = courseAuditPortalService.saveCourseAudit(
                courseAuditSaveDTO.setLecturerUserNo(userNo));
        return ResponseResult.success(CourseAuditMapStruct.INSTANCE.B2SV(result));
    }

    @PostMapping("/course/auth/course/audit/update")
    public ResponseResult updateCourseAudit(
            @RequestBody @Validated CourseAuditUpdateDTO courseAuditUpdateDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        Boolean result = courseAuditPortalService.updateCourseAudit(
                courseAuditUpdateDTO.setLecturerUserNo(userNo));
        return ResponseResult.success(result);
    }

    @PostMapping("/course/auth/course/audit/stand")
    public ResponseResult updateCourseAuditByPutaway(
            @RequestBody @Validated CourseAuditPutawayDTO courseAuditPutawayDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        Boolean result = courseAuditPortalService.updateCourseAuditByPutaway(
                courseAuditPutawayDTO.setLecturerUserNo(userNo));
        return ResponseResult.success(result);
    }

    @PostMapping("/course/auth/course/audit/delete")
    public ResponseResult deleteCourseAudit(
            @RequestBody @Validated CourseAuditDeleteDTO courseAuditDeleteDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        Boolean result = courseAuditPortalService.deleteCourseAudit(
                courseAuditDeleteDTO.setLecturerUserNo(userNo));
        return ResponseResult.success(result);
    }
}
