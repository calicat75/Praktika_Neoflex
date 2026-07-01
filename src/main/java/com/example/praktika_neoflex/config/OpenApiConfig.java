package com.example.praktika_neoflex.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI accountServiceOpenApi() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Account Service API")
                                .description("Микросервис остатков по счетам")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .name("Bank")
                                                .email("support@bank.local")
                                )
                );
    }

}
