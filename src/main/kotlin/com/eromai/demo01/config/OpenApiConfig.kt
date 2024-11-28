package com.eromai.demo01.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.Contact
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Book Store API")
                    .description("REST API for managing books")
                    .version("1.0")
                    .contact(
                        Contact()
                            .name("Your Name")
                            .email("your.email@example.com")
                    )
            )
    }
}