package com.clowneon1.aws.springbootdynamodbcrud.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class SwaggerConfig {
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        String title = "Spring Boot DynamoDB Integration";
        String description = "This API is to do crud operations on DynamoDb table named person";
        String version = "1.0";
        String serviceTerms = "It is for education purpose only";
        Contact contact =  new Contact("Yashraj Mandloi", "http://localhost:8080",
                "er.mandloiyashraj@gmail.com");

        String license = "license l1";
        String licenceUrl = "www.licensedekho.com";;
        return new ApiInfo(title,description, version, serviceTerms,contact,license,licenceUrl, Collections.emptyList());
    }
}
