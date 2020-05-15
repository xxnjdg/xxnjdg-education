package io.xxnjdg.notp.system.apis;

import io.xxnjdg.notp.system.objects.view.SysVO;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-25 下午9:27
 */
@FeignClient(name = "xxnjdg-system-service",contextId = "SysControllerApi")
public interface SysControllerApi {

    /**
     * 获取sys第一个
     * @return ResponseResult
     */
    @RequestMapping(value = "/feign/system/sys/getSys", method = RequestMethod.POST)
    ResponseResult<SysVO> getSysFirstOne();


}
