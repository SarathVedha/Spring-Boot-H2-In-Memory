package com.vedha.h2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "H2 Demo", description = "H2 InMemory DataBase Demo", version = "V1.0", contact = @Contact(name = "Console URL", url = "localhost:8080/h2-console/")))
public class H2DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2DemoApplication.class, args);
	}

}
