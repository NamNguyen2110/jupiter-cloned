package com.jupiter.oppsservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfiguration {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Opps REST operations API in Spring-Boot")
                .description(
                        "Sample REST API for centalized documentation using Spring Boot and spring-fox swagger 2 ")
                .termsOfServiceUrl("").version("0.0.1-SNAPSHOT").
                contact(new Contact("Javis Hoang", "https://hrms.cmcglobal.com.vn/timesheet",
                        "htnho@cmcglobal.vn")).build();
    }

    @Bean
    public Docket configureControllerPackageAndConvertors() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.jupiter.oppsservice.web.rest")).build()
                .apiInfo(apiInfo());
    }


}