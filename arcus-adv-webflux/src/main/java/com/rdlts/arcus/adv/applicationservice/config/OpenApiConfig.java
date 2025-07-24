package com.rdlts.arcus.adv.applicationservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(new Server().url("http://localhost:9000/arcus-adv-webflux")
                        .description("Development Server")))
                .info(new Info()
                        .title("Arcus ADV WebFlux API")
                        .description("Arcus Acro Design Vue WebFlux API Documentation")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Arcus Team")
                                .email("wangjialong02@gmail.com"))
                        .license(new License()
                                .name("GPL v3.0")
                                .url("https://www.gnu.org/licenses/gpl-3.0.txt")));
    }
}