package io.xxnjdg.notp.course.portal.controller;

import io.xxnjdg.notp.course.portal.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.portal.object.convert.CourseChapterAuditMapStruct;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.audit.*;
import io.xxnjdg.notp.course.portal.service.CourseChapterAuditPortalService;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 23:47
 */
@RestController
@Validated
public class CourseChapterAuditPortalController {
    @Autowired
    private CourseChapterAuditPortalService courseChapterAuditPortalService;

    @PostMapping("/course/auth/course/chapter/audit/list")
    public ResponseResult listCourseChapterAudit(
            @RequestBody @Validated CourseChapterAuditPageDTO courseChapterAuditPageDTO){
        List<CourseChapterAuditBO> result =
                courseChapterAuditPortalService.listCourseChapterAudit(courseChapterAuditPageDTO);
        return ResponseResult.success(CourseChapterAuditMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/course/auth/course/chapter/audit/save")
    public ResponseResult saveCourseChapterAudit(
            @RequestBody @Validated CourseChapterAuditSaveDTO courseChapterAuditSaveDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo ){
        CourseChapterAuditBO result = courseChapterAuditPortalService
                .saveCourseChapterAudit(courseChapterAuditSaveDTO.setUserNo(userNo));
        return ResponseResult.success(CourseChapterAuditMapStruct.INSTANCE.B2SV(result));
    }

    @PostMapping("/course/auth/course/chapter/audit/update")
    public ResponseResult updateCourseChapterAudit(
            @RequestBody @Validated CourseChapterAuditUpdateDTO courseChapterAuditUpdateDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo ){
        CourseChapterAuditBO result = courseChapterAuditPortalService
                .updateCourseChapterAudit(courseChapterAuditUpdateDTO.setUserNo(userNo));
        return ResponseResult.success(CourseChapterAuditMapStruct.INSTANCE.B2UV(result));
    }

    @PostMapping("/course/auth/course/chapter/audit/delete")
    public ResponseResult deleteCourseChapterAudit(
            @RequestBody @Validated CourseChapterAuditDeleteDTO courseChapterAuditDeleteDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo ){
        Boolean result = courseChapterAuditPortalService
                .deleteCourseChapterAudit(courseChapterAuditDeleteDTO.setUserNo(userNo));
        return ResponseResult.success(result);
    }

    @PostMapping("/course/auth/course/chapter/audit/sort")
    public ResponseResult sortCourseChapterAudit(
            @RequestBody @Validated CourseChapterAuditSortDTO courseChapterAuditSortDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo ){
        Boolean result = courseChapterAuditPortalService
                .sortCourseChapterAudit(courseChapterAuditSortDTO.setUserNo(userNo));
        return ResponseResult.success(result);
    }
}
