package com.walmart.mx.dws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Dummy Item File API", version = "1.0", description = "Item Marge and ItemFile Integration Component"))
public class OptimusApplication {

    public static void main(final String[] args) {
        SpringApplication.run(OptimusApplication.class, args);
    }

}
