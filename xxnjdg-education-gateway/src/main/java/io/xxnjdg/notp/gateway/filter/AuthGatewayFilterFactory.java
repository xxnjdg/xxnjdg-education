package io.xxnjdg.notp.gateway.filter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.xxnjdg.notp.gateway.error.ErrorStatus;
import io.xxnjdg.notp.utils.constant.RedisPrefixField;
import io.xxnjdg.notp.utils.custom.utils.JWTUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;


/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-24 下午8:17
 */
@Component
@Slf4j
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public AuthGatewayFilterFactory() {
        super(AuthGatewayFilterFactory.Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();
            String path = request.getPath().toString();

            log.error(request.getRemoteAddress().toString());

            log.info(path);
            if (path.contains("/callback") || path.contains("/api")) {
                return chain.filter(exchange);
            }

            try {
                // 获得 token
                HttpHeaders headers = request.getHeaders();
                String token = headers.getFirst(config.getTokenHeaderName());

                // 如果没有 token，则不进行认证。因为可能是无需认证的 API 接口
                if (StrUtil.isBlank(token)) {
                    throw new BaseException(ErrorStatus.TOKEN_NULL);
                }

                DecodedJWT verify = JWTUtil.verify(token);

                if (verify == null) {
                    throw new BaseException(ErrorStatus.TOKEN_NULL);
                }

                log.error(String.valueOf(request.getHeaders().size()));

                String userNo = verify.getClaim("userNo").asString();

                String key = RedisPrefixField.LOGIN_PREFIX+userNo;
                String jwt = stringRedisTemplate.opsForValue().get(key);
                //token 已过期
                if (StrUtil.isBlank(jwt)) {
                    throw new BaseException(ErrorStatus.TOKEN_NULL);
                }

                log.error("jwt "+jwt);
                log.error("token "+token);
                if (!ObjectUtil.equal(jwt,token)){
                    throw new BaseException(ErrorStatus.TOKEN_NULL);
                }

                Long expire = stringRedisTemplate.getExpire(key);

                //-2 建不存在 -1 不过期,让用户重新登陆
                if (expire == null || expire < 0){
                    throw new BaseException(ErrorStatus.TOKEN_NULL);
                }

                if (10 * 60 > expire) {
                    stringRedisTemplate.opsForValue().set(key,jwt,30, TimeUnit.MINUTES);
                }

                // <6> 认证通过，将 userId 添加到 Header 中
                request = request.mutate().header(config.getUserIdHeaderName(), userNo)
                        .build();

                log.error(String.valueOf(request.getHeaders().size()));


                // 使用修改后的ServerHttpRequestDecorator重新生成一个新的ServerWebExchange
                return chain.filter(exchange.mutate().request(request).build());
            } catch (Exception e) {
                e.printStackTrace();
                throw new BaseException(ErrorStatus.TOKEN_NULL);
            }
        };
    }

    private Mono<Void> responseResult(ServerWebExchange exchange, ServerHttpResponse response) {
        // 响应 401 状态码
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
        // 响应提示
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap("认证不通过".getBytes());
        return response.writeWith(Flux.just(buffer));
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
