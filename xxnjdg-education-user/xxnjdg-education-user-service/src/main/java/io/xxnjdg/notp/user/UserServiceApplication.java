package io.xxnjdg.notp.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午9:36
 */
@SpringBootApplication
@MapperScan(basePackages = {"io.xxnjdg.notp.user.mapper"})
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class);
    }
}
