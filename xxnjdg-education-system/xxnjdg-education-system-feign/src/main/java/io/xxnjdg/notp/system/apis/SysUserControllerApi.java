package io.xxnjdg.notp.system.apis;

import io.xxnjdg.notp.system.objects.data.transfer.SysUserDTO;
import io.xxnjdg.notp.system.objects.view.SysUserVO;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-14 下午7:13
 */
@FeignClient(name = "xxnjdg-system-service",contextId = "SysUserControllerApi")
public interface SysUserControllerApi {

    /**
     * 根据 userNo 查询 menu
     * @param sysUserDTO
     * @return
     */
    @RequestMapping(value = "/feign/system/sysMenu/listForPage", method = RequestMethod.POST)
    ResponseResult<SysUserVO> listMenuApiUrl(@RequestBody @Validated SysUserDTO sysUserDTO);
}
