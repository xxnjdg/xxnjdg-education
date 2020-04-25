package io.xxnjdg.notp.system.apis;

import io.xxnjdg.notp.system.objects.view.SysVO;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-25 下午9:27
 */
@FeignClient("xxnjdg-system-service")
public interface SysControllerApi {

    /**
     * 获取sys第一个
     * @return ResponseResult
     */
    ResponseResult<SysVO> getSysFirstOne();


}
