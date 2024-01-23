package com.theone.nailtherapyspring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Value("${nailtherapy.openapi.dev-url}")
    private String devURL;

    @Value("${nailtherapy.openapi.prod-url}")
    private String prodURL;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devURL);
        devServer.setDescription("Development environment server URL");

        Server prodServer = new Server();
        prodServer.setUrl(prodURL);
        prodServer.setDescription("Production environment server URL");

        Contact contact = new Contact();
        contact.setName("Terri Penn");
        contact.setEmail("coderterri@protonmail.com");
        contact.setUrl("https://terripenn.dev");

        Info info = new Info()
                .title("Nail Therapy API")
                .version("0.1")
                .description("This API exposes endpoints to manage users, clients, services of Lovie's Nails.")
                .contact(contact);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
