package com.hh.tech_project;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Users & Subscription API",
                version = "1.0",
                description = "Documentation for Users & Subscription REST API"
        )
)
public class TechProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechProjectApplication.class, args);
    }

}
