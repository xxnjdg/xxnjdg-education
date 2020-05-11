package io.xxnjdg.notp.course.controller;



import io.xxnjdg.notp.course.object.business.CourseChapterPeriodAuditBO;
import io.xxnjdg.notp.course.object.convert.CourseChapterPeriodAuditMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.CourseChapterPeriodAuditBTO;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseChapterPeriodAuditBTO;
import io.xxnjdg.notp.course.object.view.ListCourseChapterPeriodAuditVO;
import io.xxnjdg.notp.course.service.CourseChapterPeriodAuditService;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 课时信息-审核 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@RestController
@Validated
public class CourseChapterPeriodAuditController {

    @Autowired
    private CourseChapterPeriodAuditService courseChapterPeriodAuditService;

    @PostMapping("/course/auth/course/chapter/period/audit/list")
    public ResponseResult listCourseChapterPeriodAudit(
            @RequestBody @Validated ListCourseChapterPeriodAuditBTO listCourseChapterPeriodAuditBTO){
        List<CourseChapterPeriodAuditBO> courseChapterPeriodAuditBOS =
                courseChapterPeriodAuditService.listCourseChapterPeriodAudit(listCourseChapterPeriodAuditBTO);

        List<ListCourseChapterPeriodAuditVO> listCourseChapterPeriodAuditVOS =
                CourseChapterPeriodAuditMapStruct.INSTANCE.convertB2V(courseChapterPeriodAuditBOS);

        return ResponseResult.success(listCourseChapterPeriodAuditVOS);
    }



    @PostMapping("/course/auth/course/chapter/period/audit/save")
    public ResponseResult insertCourseChapterPeriodAudit(
            @RequestBody @Validated(Insert.class) CourseChapterPeriodAuditBTO courseChapterPeriodAuditBTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo ){

        CourseChapterPeriodAuditBO courseChapterPeriodAuditBO = courseChapterPeriodAuditService
                .insertCourseChapterPeriodAudit(courseChapterPeriodAuditBTO.setUserNo(userNo));

        return ResponseResult.success();
    }
}

