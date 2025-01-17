package com.huerta.sb_ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info
	(
		title = "E-Commerce API",
		version = "v1",
		description = "E-Commerce Rest API Documentation",
		contact = @Contact(
			name = "Israel Huerta",
			email = "israelhf24@gmail.com",
			url = "https://github.com/IsraelHuerta"
		),
		license = @License
		(
			name = "Apache 2.0",
			url = "http://www.apache.org/licenses/LICENSE-2.0.html"
		)
	)
)
public class SbEcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbEcomApplication.class, args);
	}

}
