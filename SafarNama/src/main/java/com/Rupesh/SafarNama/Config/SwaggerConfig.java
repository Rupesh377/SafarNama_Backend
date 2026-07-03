package com.Rupesh.SafarNama.Config;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig
{
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                                .title("SafarNama API")
                                .version("1.0")
                                .description("Backend APIs for SafarNama Trekking Website")
                                .contact(new Contact().name("Rupesh").email("kr.rupesh1604@gmail.com")));
    }
}
