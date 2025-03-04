/*
package com.service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Home4U API", version = "3.0", description = "Documentation API v1.0")
)
@SecurityScheme(name = "Home4U", scheme = "Bearer",
        type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER,
        bearerFormat = "JWT")
public class SwaggerConfig {

    @Value("${server.servlet.context-path}")
    private String context;

    @Value("${server.servlet.version}")
    private String version;
    @Bean
    public OpenAPI api() {
        return new OpenAPI().addServersItem(new Server().url(context).description(version));
    }
}
*/
