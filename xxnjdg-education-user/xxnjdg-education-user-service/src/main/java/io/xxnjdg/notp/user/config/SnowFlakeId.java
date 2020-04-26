package io.xxnjdg.notp.user.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-26 下午6:34
 */
@Component
@Getter
public class SnowFlakeId {

    @Value("${info.snowFlakeId.workerId}")
    private long workerId;

    @Value("${info.snowFlakeId.dataCenterId}")
    private long dataCenterId;

}
