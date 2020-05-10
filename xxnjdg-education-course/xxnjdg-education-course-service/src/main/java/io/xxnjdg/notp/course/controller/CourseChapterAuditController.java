package io.xxnjdg.notp.course.controller;


import io.xxnjdg.notp.course.object.business.CourseChapterAuditBO;
import io.xxnjdg.notp.course.object.convert.CourseChapterAuditMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.InsertCourseChapterAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseChapterAuditDTO;
import io.xxnjdg.notp.course.object.view.InsertCourseChapterAuditVO;
import io.xxnjdg.notp.course.object.view.ListCourseChapterAuditVO;
import io.xxnjdg.notp.course.service.CourseChapterAuditService;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 章节信息-审核 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@RestController
public class CourseChapterAuditController {

    @Autowired
    private CourseChapterAuditService courseChapterAuditService;

    @PostMapping("/course/auth/course/chapter/audit/list")
    public ResponseResult listCourseChapterAudit(
            @RequestBody @Validated ListCourseChapterAuditDTO listCourseChapterAuditDTO){
        List<CourseChapterAuditBO> courseChapterAuditBOS =
                courseChapterAuditService.listCourseChapterAudit(listCourseChapterAuditDTO);
        List<ListCourseChapterAuditVO> listCourseChapterAuditVOS =
                CourseChapterAuditMapStruct.INSTANCE.convertB2V(courseChapterAuditBOS);
        return ResponseResult.success(listCourseChapterAuditVOS);
    }

    @PostMapping("/course/auth/course/chapter/audit/save")
    public ResponseResult insertCourseChapterAudit(
            @RequestBody @Validated InsertCourseChapterAuditDTO insertCourseChapterAuditDTO,
            @RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo ){
        CourseChapterAuditBO courseChapterAuditBO =
                courseChapterAuditService.insertCourseChapterAudit(
                        insertCourseChapterAuditDTO.setUserNo(userNo));

        InsertCourseChapterAuditVO insertCourseChapterAuditVO =
                CourseChapterAuditMapStruct.INSTANCE.convertB2V(courseChapterAuditBO);
        return ResponseResult.success(insertCourseChapterAuditVO);
    }


}

