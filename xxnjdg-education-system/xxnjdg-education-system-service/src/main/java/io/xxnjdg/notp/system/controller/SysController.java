package io.xxnjdg.notp.system.controller;


import io.xxnjdg.notp.system.apis.SysControllerApi;
import io.xxnjdg.notp.system.convert.SysToSysVO;
import io.xxnjdg.notp.system.object.persistent.Sys;
import io.xxnjdg.notp.system.objects.view.SysVO;
import io.xxnjdg.notp.system.service.SysService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 系统配置表 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@RestController
public class SysController implements SysControllerApi {

    @Autowired
    private SysService sysService;

    @Override
    public ResponseResult<SysVO> getSysFirstOne() {
        List<Sys> list = sysService.list();
        SysVO sysVO = SysToSysVO.INSTANCE.convert(list.get(0));
        return ResponseResult.success(sysVO);
    }
}

