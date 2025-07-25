package com.example.bookstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI bookstoreOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Bookstore API")
            .description("Simple REST API for managing books and authors")
            .version("1.0"));
    }
}
