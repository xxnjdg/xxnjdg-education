package io.xxnjdg.notp.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午9:42
 */
//@Component
@Slf4j
public class globalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

//        log.info("my log        "+ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
//        log.info("my log        "+ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
//        log.info("my log        "+ServerWebExchangeUtils.GATEWAY_SCHEME_PREFIX_ATTR);
//        log.info("my log        "+ServerWebExchangeUtils.CLIENT_RESPONSE_ATTR);
//        log.info("my log        "+ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
