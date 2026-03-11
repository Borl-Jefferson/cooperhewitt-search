package org.jointheleague.cooperhewitt.Cooperhewitt.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cooper Hewitt API")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Matt Freedman")
                                .url("www.jointheleague.org")
                                .email("matt.freedman@jointheleague.org")));
    }
}