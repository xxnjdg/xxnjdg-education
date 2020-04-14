package io.xxnjdg.notp.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午1:42
 */
@SpringBootApplication
@MapperScan(basePackages = {"io.xxnjdg.notp.course.mapper"})
public class CourseServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApplication.class);
    }
}
