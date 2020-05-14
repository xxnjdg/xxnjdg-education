package io.xxnjdg.notp.system.apis;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-14 下午6:53
 */
@FeignClient("xxnjdg-system-service")
public interface SysMenuControllerApi {

}
