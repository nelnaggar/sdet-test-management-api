package pro.netech.testmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI testManagementApi() {

        return new OpenAPI()

                .info(new Info()

                        .title("SDET Test Management API")

                        .version("1.0")

                        .description("""
                                REST API demonstrating a layered Spring Boot application
                                for managing software test cases.
                                Developed as a portfolio project using:

                                • Spring Boot
                                • Spring Data JPA
                                • Hibernate
                                • H2 Database
                                • Validation
                                • Lombok
                                • OpenAPI / Swagger
                                """)

                        .contact(new Contact()
                                .name("Nader El-Naggar")
                                .email("nader@elnaggar.net"))

                        .license(new License()
                                .name("MIT License")));
    }

}