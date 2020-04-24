package io.xxnjdg.notp.gateway.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import io.xxnjdg.notp.utils.custom.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-24 下午8:17
 */
@Component
@Slf4j
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {


    public AuthGatewayFilterFactory() {
        super(AuthGatewayFilterFactory.Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getPath().toString();
            log.info(path);
            if (path.contains("/callback") || path.contains("/api") ){
                chain.filter(exchange);
            }

//            request = request.mutate().header(config.getUserIdHeaderName(), "2019011715195672").build();

            // 获得 token
            HttpHeaders headers = request.getHeaders();
            String token = headers.getFirst(config.getTokenHeaderName());

            // 如果没有 token，则不进行认证。因为可能是无需认证的 API 接口
            if (!StringUtils.hasText(token)) {

            }

            try {
                DecodedJWT verify = JWTUtil.verify(token);

                if (verify == null){

                }

                Long userNo = Long.valueOf(verify.getClaim("userNo").asString());
            }catch (Exception e){
                e.printStackTrace();
            }

            HttpServletRequestWrapper


            // 认证通过，将 userId 添加到 Header 中
            request = request.mutate().header(config.getUserIdHeaderName(), String.valueOf(userId))
                    .build();

//            return chain.filter(exchange.mutate().request(request).build());
            return true;

        };
    }

    public static class Config {

        private static final String DEFAULT_TOKEN_HEADER_NAME = "token";
        private static final String DEFAULT_HEADER_NAME = "userNo";

        private String tokenHeaderName = DEFAULT_TOKEN_HEADER_NAME;
        private String userIdHeaderName = DEFAULT_HEADER_NAME;

        public String getTokenHeaderName() {
            return tokenHeaderName;
        }

        public String getUserIdHeaderName() {
            return userIdHeaderName;
        }

        public Config setTokenHeaderName(String tokenHeaderName) {
            this.tokenHeaderName = tokenHeaderName;
            return this;
        }

        public Config setUserIdHeaderName(String userIdHeaderName) {
            this.userIdHeaderName = userIdHeaderName;
            return this;
        }

    }
}
