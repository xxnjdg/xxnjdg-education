package io.xxnjdg.notp.system.controller;


import io.xxnjdg.notp.system.apis.SysUserControllerApi;
import io.xxnjdg.notp.system.object.business.SysUserBO;
import io.xxnjdg.notp.system.objects.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.service.SysUserService;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 后台用户信息 前端控制器
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-16
 */
@RestController
public class SysUserController implements SysUserControllerApi {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResponseResult<List<String>> listMenuApiUrl(SysUserDTO sysUserDTO) {
        SysUserBO sysUserBO = sysUserService.listMenuApiUrl(sysUserDTO);

        return ResponseResult.success();
    }
}

