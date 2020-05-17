package io.xxnjdg.notp.system.controller.admin;

import io.xxnjdg.notp.system.object.business.SysMenuBO;
import io.xxnjdg.notp.system.object.convert.SysMenuMapStruct;
import io.xxnjdg.notp.system.object.data.transfer.SysMenuDTO;
import io.xxnjdg.notp.system.object.view.ButtonVO;
import io.xxnjdg.notp.system.object.view.DirectoryAndMenuVO;
import io.xxnjdg.notp.system.service.SysMenuService;
import io.xxnjdg.notp.utils.constant.ValidationMessage;
import io.xxnjdg.notp.utils.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/16 18:26
 */
@RestController
@Slf4j
public class SysMenuAdminController {

    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping("/system/pc/menu/user/button/list")
    public ResponseResult listButton(@RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        List<SysMenuBO> sysMenuBOList = sysMenuService.listButton(new SysMenuDTO().setUserNo(userNo));
        List<ButtonVO> buttonVOList = SysMenuMapStruct.INSTANCE.convertListButtonVO(sysMenuBOList);
        return ResponseResult.success(buttonVOList);
    }

    @PostMapping("/system/pc/menu/user/list")
    public ResponseResult listDirectoryAndMenu(@RequestHeader("userNo") @NotNull(message = ValidationMessage.PARAMETER_NULL) Long userNo){
        List<SysMenuBO> sysMenuBOList = sysMenuService.listDirectoryAndMenu(new SysMenuDTO().setUserNo(userNo));
        List<DirectoryAndMenuVO> directoryAndMenuVOList = SysMenuMapStruct.INSTANCE.convertListDirectoryAndMenuVO(sysMenuBOList);
        return ResponseResult.success(directoryAndMenuVOList);
    }

}
