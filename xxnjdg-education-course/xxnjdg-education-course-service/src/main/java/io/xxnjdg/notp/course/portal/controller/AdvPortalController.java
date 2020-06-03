package io.xxnjdg.notp.course.portal.controller;

import io.xxnjdg.notp.course.portal.object.business.AdvBO;
import io.xxnjdg.notp.course.portal.object.convert.AdvMapStruct;
import io.xxnjdg.notp.course.portal.object.data.transfer.adv.AdvPageDTO;
import io.xxnjdg.notp.course.portal.service.AdvPortalService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/27 1:39
 */
@RestController
public class AdvPortalController {

    @Autowired
    private AdvPortalService advPortalService;

    @PostMapping("/course/api/adv/list")
    public ResponseResult listAdv(@RequestBody @Validated AdvPageDTO advPageDTO ){
        List<AdvBO> result = advPortalService.listAdv(advPageDTO);
        return ResponseResult.success(AdvMapStruct.INSTANCE.B2PV(result));
    }

}
