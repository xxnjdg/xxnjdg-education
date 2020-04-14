package io.xxnjdg.notp.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午9:35
 */
@SpringBootApplication
@MapperScan(basePackages = {"io.xxnjdg.notp.system.mapper"})
public class SystemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemServiceApplication.class);
    }
}
