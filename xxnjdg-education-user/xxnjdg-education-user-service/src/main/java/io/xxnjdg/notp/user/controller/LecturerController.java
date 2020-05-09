package io.xxnjdg.notp.user.controller;


import io.xxnjdg.notp.user.apis.LecturerControllerApi;
import io.xxnjdg.notp.user.object.business.LecturerBO;
import io.xxnjdg.notp.user.object.convert.LecturerBOToVO;
import io.xxnjdg.notp.user.object.data.transfer.LecturerUserNoDTO;
import io.xxnjdg.notp.user.object.view.LecturerUserNoVO;
import io.xxnjdg.notp.user.object.view.LecturerVO;
import io.xxnjdg.notp.user.service.LecturerService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 讲师信息 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@RestController
public class LecturerController implements LecturerControllerApi {

    @Autowired
    private LecturerService lecturerService;

    @Override
    public ResponseResult<LecturerVO> getLecturerByLecturerUserNo(Long lecturerUserNo) {
        LecturerUserNoDTO lecturerUserNoDTO =
                new LecturerUserNoDTO().setLecturerUserNo(lecturerUserNo.toString());
        LecturerBO lecturerBO = lecturerService.getLecturerAndExtByLecturerUserNo(lecturerUserNoDTO);
        LecturerVO lecturerVO = LecturerBOToVO.INSTANCE.convertLecturerVO(lecturerBO);
        return ResponseResult.success(lecturerVO);
    }


    @PostMapping("/user/auth/lecturer/view")
    public ResponseResult postLecturerByLecturerUserNo(@RequestBody @Validated LecturerUserNoDTO lecturerUserNoDTO){
        LecturerBO lecturerBO = lecturerService.getLecturerByLecturerUserNo(lecturerUserNoDTO);
        LecturerUserNoVO lecturerUserNoVO = LecturerBOToVO.INSTANCE.convert(lecturerBO);
        return ResponseResult.success(lecturerUserNoVO);
    }
}

