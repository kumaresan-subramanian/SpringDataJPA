package com.example.data.jpa;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = " Spring boot Data JPA",
				description = " Spring boot Data JPA",
				version = "v1.0",
				contact = @Contact(
						name = "kumaresan",
						email = "kumar@jack.com",
						url = "http://www.kumar.jack.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.kumar.jack.com"	
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "User Documentation",
				url = "http://www.kumar.jack.com"
		)
)
public class SpringDataJpaApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
