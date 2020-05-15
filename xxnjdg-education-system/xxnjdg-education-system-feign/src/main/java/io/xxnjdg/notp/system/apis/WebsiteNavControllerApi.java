package io.xxnjdg.notp.system.apis;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-16 下午12:31
 */
@FeignClient(name = "xxnjdg-system-service",contextId = "WebsiteNavControllerApi")
public interface WebsiteNavControllerApi {



}
