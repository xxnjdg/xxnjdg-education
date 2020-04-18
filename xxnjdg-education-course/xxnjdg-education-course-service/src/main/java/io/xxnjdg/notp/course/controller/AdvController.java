package io.xxnjdg.notp.course.controller;


import io.xxnjdg.notp.course.object.data.transfer.AdvDTO;
import io.xxnjdg.notp.course.object.view.AdvVO;
import io.xxnjdg.notp.course.service.AdvService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 广告信息 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@RestController
public class AdvController {

    @Autowired
    private AdvService advService;

    @PostMapping("/course/api/adv/list")
    public ResponseResult postAdvList(@RequestBody @Validated AdvDTO advDto){
        List<AdvVO> advVoList = advService.postAdvList(advDto);
        return ResponseResult.success(advVoList);
    }

}

