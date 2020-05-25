package io.xxnjdg.notp.user.admin.controller;

import io.xxnjdg.notp.user.admin.api.LecturerAdminControllerApi;
import io.xxnjdg.notp.user.admin.object.business.LecturerBO;
import io.xxnjdg.notp.user.admin.object.convert.LecturerMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerDTO;
import io.xxnjdg.notp.user.admin.object.view.LecturerVO;
import io.xxnjdg.notp.user.admin.service.LecturerAdminService;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Get;
import io.xxnjdg.notp.utils.validator.group.Page;
import io.xxnjdg.notp.utils.validator.group.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/23 15:49
 */
@RestController
public class LecturerAdminController implements LecturerAdminControllerApi {

    @Autowired
    private LecturerAdminService lecturerAdminService;

    @Override
    public ResponseResult<List<LecturerVO>> getLecturerByIds(Collection<Long> ids) {
        List<Lecturer> lecturers = lecturerAdminService.listByIds(ids);
        return ResponseResult.success(LecturerMapStruct.INSTANCE.P2V(lecturers));
    }

    @PostMapping("/user/pc/lecturer/list")
    public ResponseResult listLecturerByPage(@RequestBody @Validated(Page.class) LecturerDTO lecturerDTO ){
        PageResult<LecturerBO> result = lecturerAdminService.listLecturerByPage(lecturerDTO);
        return ResponseResult.success(LecturerMapStruct.INSTANCE.B2PV(result));
    }

    @PostMapping("/user/pc/lecturer/update")
    public ResponseResult updateLecturer(@RequestBody @Validated(Update.class) LecturerDTO lecturerDTO ){
        Boolean result = lecturerAdminService.updateLecturer(lecturerDTO);
        return ResponseResult.success(result);
    }

    @PostMapping("/user/pc/lecturer/view")
    public ResponseResult getLecturer(@RequestBody @Validated(Get.class) LecturerDTO lecturerDTO ){
        LecturerBO result = lecturerAdminService.getLecturer(lecturerDTO);
        return ResponseResult.success(LecturerMapStruct.INSTANCE.B2VV(result));
    }
}
