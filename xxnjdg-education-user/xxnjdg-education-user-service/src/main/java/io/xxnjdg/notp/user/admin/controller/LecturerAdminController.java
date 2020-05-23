package io.xxnjdg.notp.user.admin.controller;

import io.xxnjdg.notp.user.admin.api.LecturerAdminControllerApi;
import io.xxnjdg.notp.user.admin.object.convert.LecturerMapStruct;
import io.xxnjdg.notp.user.admin.object.view.LecturerVO;
import io.xxnjdg.notp.user.admin.service.LecturerAdminService;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
