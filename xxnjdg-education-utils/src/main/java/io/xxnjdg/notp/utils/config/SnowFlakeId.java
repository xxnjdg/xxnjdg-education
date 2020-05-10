package io.xxnjdg.notp.utils.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-5-10 下午3:34
 */
@Component
@Getter
public class SnowFlakeId {

    @Value("${info.snowFlakeId.workerId}")
    private long workerId;

    @Value("${info.snowFlakeId.dataCenterId}")
    private long dataCenterId;

}