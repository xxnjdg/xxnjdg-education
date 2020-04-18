package io.xxnjdg.notp.course.controller;


import io.xxnjdg.notp.course.object.data.transfer.ZoneDTO;
import io.xxnjdg.notp.course.object.view.ZoneVO;
import io.xxnjdg.notp.course.service.ZoneService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 专区 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@RestController
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @PostMapping("/course/api/zone/course/list")
    public ResponseResult postZoneCourseList(@RequestBody @Validated ZoneDTO zoneDTO){
        List<ZoneVO> zoneVOList = zoneService.postZoneCourseList(zoneDTO);
        return ResponseResult.success(zoneVOList);
    }

}

