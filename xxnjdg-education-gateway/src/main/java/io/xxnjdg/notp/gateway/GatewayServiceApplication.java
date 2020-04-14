package io.xxnjdg.notp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午4:10
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}
