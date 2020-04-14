package io.xxnjdg.notp.utils.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午2:54
 */
@Configuration
@EnableSwagger2
public class GeneralSwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Boot 项目集成 Swagger 实例文档",
                "我的博客网站：https://xxnjdg.github.io，欢迎大家访问。",
                "API V1.0",
                "Terms of service",
                new Contact("名字想好没", "https://xxnjdg.github.io", "https://xxnjdg.github.io"),
                "Apache", "http://www.apache.org/", Collections.emptyList());
    }
}
