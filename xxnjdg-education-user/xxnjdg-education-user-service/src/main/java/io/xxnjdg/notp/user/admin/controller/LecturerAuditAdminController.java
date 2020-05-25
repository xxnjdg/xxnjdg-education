package io.xxnjdg.notp.user.admin.controller;

import io.xxnjdg.notp.user.admin.object.business.LecturerAuditBO;
import io.xxnjdg.notp.user.admin.object.convert.LecturerAuditMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerAuditDTO;
import io.xxnjdg.notp.user.admin.service.LecturerAuditAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/24 16:01
 */
@RestController
public class LecturerAuditAdminController {
    @Autowired
    private LecturerAuditAdminService lecturerAuditAdminService;

    @PostMapping("/user/pc/lecturer/audit/list")
    public ResponseResult listLecturerAuditByPage(@RequestBody @Validated(Page.class) LecturerAuditDTO lecturerAuditDTO ){
        PageResult<LecturerAuditBO> result = lecturerAuditAdminService.listLecturerAuditByPage(lecturerAuditDTO);
        return ResponseResult.success(LecturerAuditMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/user/pc/lecturer/audit/save")
    public ResponseResult saveLecturerAudit(@RequestBody @Validated(Insert.class) LecturerAuditDTO lecturerAuditDTO ){
        Boolean result = lecturerAuditAdminService.saveLecturerAudit(lecturerAuditDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/user/pc/lecturer/audit/update")
    public ResponseResult updateLecturerAudit(@RequestBody @Validated(Update.class) LecturerAuditDTO lecturerAuditDTO ){
        Boolean result = lecturerAuditAdminService.updateLecturerAudit(lecturerAuditDTO);
        return ResponseResult.success(result);
    }
    @PostMapping("/user/pc/lecturer/audit/view")
    public ResponseResult getLecturerAudit(@RequestBody @Validated(View.class) LecturerAuditDTO lecturerAuditDTO ){
        LecturerAuditBO result = lecturerAuditAdminService.getLecturerAudit(lecturerAuditDTO);
        return ResponseResult.success(LecturerAuditMapStruct.INSTANCE.B2VV(result));
    }

    @PostMapping("/user/pc/lecturer/audit/audit")
    public ResponseResult auditLecturerAudit(@RequestBody @Validated(ListGroup.class) LecturerAuditDTO lecturerAuditDTO ){
        Boolean result = lecturerAuditAdminService.auditLecturerAudit(lecturerAuditDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/user/pc/lecturer/audit/check")
    public ResponseResult checkLecturerAudit(@RequestBody @Validated(Get.class) LecturerAuditDTO lecturerAuditDTO ){
        Boolean result = lecturerAuditAdminService.checkLecturerAudit(lecturerAuditDTO);
        return ResponseResult.success(result);
    }
}
