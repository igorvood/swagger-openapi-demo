package ru.vood.swagger.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.GroupedOpenApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.List


@Configuration
open class SwaggerConfig {

    @Bean
    open fun publicUserApi(): GroupedOpenApi =
        GroupedOpenApi.builder()
            .group("Users")
            .pathsToMatch("/users/**")
            .build()

    @Bean
    open  fun customOpenApi(
        @Value("\${application-description}") appDescription: String,
        @Value("\${application-version}") appVersion: String
    ): OpenAPI {
        return OpenAPI().info(
            Info().title("Application API")
                .version(appVersion)
                .description(appDescription)
                .license(
                    License().name("Apache 2.0")
                        .url("http://springdoc.org")
                )
                .contact(
                    Contact().name("username")
                        .email("test@gmail.com")
                )
        )
            .servers(
                List.of(
                    Server().url("http://localhost:8080")
                        .description("Dev service"),
                    Server().url("http://localhost:8082")
                        .description("Beta service")
                )
            )
    }

}