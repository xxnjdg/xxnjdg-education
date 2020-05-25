package io.xxnjdg.notp.user.admin.controller;

import io.xxnjdg.notp.user.admin.object.business.LecturerProfitBO;
import io.xxnjdg.notp.user.admin.object.convert.LecturerProfitMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerProfitDTO;
import io.xxnjdg.notp.user.admin.service.LecturerProfitAdminService;
import io.xxnjdg.notp.utils.response.PageResult;
import io.xxnjdg.notp.utils.response.ResponseResult;
import io.xxnjdg.notp.utils.validator.group.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 17:53
 */
@RestController
public class LecturerProfitAdminController {
    @Autowired
    private LecturerProfitAdminService lecturerProfitAdminService;

    @PostMapping("/user/pc/lecturer/profit/list")
    public ResponseResult listLecturerProfitByPage(@RequestBody @Validated(Page.class) LecturerProfitDTO lecturerProfitDTO ){
        PageResult<LecturerProfitBO> result = lecturerProfitAdminService.listLecturerProfitByPage(lecturerProfitDTO);
        return ResponseResult.success(LecturerProfitMapStruct.INSTANCE.B2PV(result));
    }
}
