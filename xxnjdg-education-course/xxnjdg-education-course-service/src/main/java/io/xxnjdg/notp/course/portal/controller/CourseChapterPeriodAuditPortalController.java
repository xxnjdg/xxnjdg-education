package io.xxnjdg.notp.course.portal.controller;

import io.xxnjdg.notp.course.portal.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.portal.object.convert.CourseChapterPeriodAuditMapStruct;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditDeleteDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditPageDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditSaveDTO;
import io.xxnjdg.notp.course.portal.object.data.transfer.course.chapter.period.audit.CourseChapterPeriodAuditUpdateDTO;
import io.xxnjdg.notp.course.portal.service.CourseChapterPeriodAuditPortalService;
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
 * @date 2020/5/30 23:56
 */
@RestController
@Validated
public class CourseChapterPeriodAuditPortalController {

    @Autowired
    private CourseChapterPeriodAuditPortalService courseChapterPeriodAuditPortalService;

    @PostMapping("/course/auth/course/chapter/period/audit/list")
    public ResponseResult listCourseChapterPeriodAudit(
            @RequestBody @Validated CourseChapterPeriodAuditPageDTO courseChapterPeriodAuditPageDTO){
        List<CourseChapterPeriodAuditBO> result = courseChapterPeriodAuditPortalService
                .listCourseChapterPeriodAudit(courseChapterPeriodAuditPageDTO);
        return ResponseResult.success(CourseChapterPeriodAuditMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/course/auth/course/chapter/period/audit/save")
    public ResponseResult saveCourseChapterPeriodAudit(
            @RequestBody @Validated CourseChapterPeriodAuditSaveDTO courseChapterPeriodAuditSaveDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        CourseChapterPeriodAuditBO result = courseChapterPeriodAuditPortalService
                .saveCourseChapterPeriodAudit(courseChapterPeriodAuditSaveDTO.setUserNo(userNo));
        return ResponseResult.success(CourseChapterPeriodAuditMapStruct.INSTANCE.B2SV(result));
    }

    @PostMapping("/course/auth/course/chapter/period/audit/update")
    public ResponseResult updateCourseChapterPeriodAudit(
            @RequestBody @Validated CourseChapterPeriodAuditUpdateDTO courseChapterPeriodAuditUpdateDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        Boolean result = courseChapterPeriodAuditPortalService
                .updateCourseChapterPeriodAudit(courseChapterPeriodAuditUpdateDTO.setUserNo(userNo));
        return ResponseResult.success(result);
    }

    @PostMapping("/course/auth/course/chapter/period/audit/delete")
    public ResponseResult deleteCourseChapterPeriodAudit(
            @RequestBody @Validated CourseChapterPeriodAuditDeleteDTO courseChapterPeriodAuditDeleteDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        Boolean result = courseChapterPeriodAuditPortalService
                .deleteCourseChapterPeriodAudit(courseChapterPeriodAuditDeleteDTO.setUserNo(userNo));
        return ResponseResult.success(result);
    }


}
