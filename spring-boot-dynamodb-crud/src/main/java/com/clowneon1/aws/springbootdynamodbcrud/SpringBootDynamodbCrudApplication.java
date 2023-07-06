package com.clowneon1.aws.springbootdynamodbcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringBootDynamodbCrudApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDynamodbCrudApplication.class, args);
    }

}
