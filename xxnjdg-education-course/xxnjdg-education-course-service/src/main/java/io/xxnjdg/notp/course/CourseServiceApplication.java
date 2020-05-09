package io.xxnjdg.notp.course;

import io.xxnjdg.notp.utils.config.GeneralSwaggerConfig;
import io.xxnjdg.notp.utils.exception.HandlerException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午1:42
 */
@SpringBootApplication
@MapperScan(basePackages = {"io.xxnjdg.notp.course.mapper"})
@Import({GeneralSwaggerConfig.class, HandlerException.class})
@EnableFeignClients(basePackages = "io.xxnjdg.notp.*")
@EnableEurekaClient
public class CourseServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApplication.class);
    }
}
