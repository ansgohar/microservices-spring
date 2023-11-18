package com.gohar.commerce.productcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableFeignClients
//@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {ApplicationContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Product Catalouge  Microservice REST API Documentation",
				description = "Product Information microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Ahmad Gohar",
						email = "info@agohar.me",
						url = "https://www.agohar.me"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.agohar.me"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "HorusSoft REST API Documentation",
				url = "https://www.agohar.me/swagger-ui.html"
		)
)
public class ProductCatalogueMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueMsApplication.class, args);
	}

}
