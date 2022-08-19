package com.jupiter.oppsservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerDocumentationConfiguration {

    private final Environment env;

    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Opps Service API ")
                .description(
                        "Here is the Swagger for Opps Service  ")
                .termsOfServiceUrl("").version("0.0.1-SNAPSHOT").
                contact(new Contact("Javis Hoang", "https://hrms.cmcglobal.com.vn/timesheet",
                        "htnho@cmcglobal.vn")).build();
    }

    @Bean
    public Docket configureControllerPackageAndConvertors() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(env.getProperty("swagger.baseUrl"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jupiter.oppsservice.controller")).build()
                .apiInfo(apiInfo());
    }


}
