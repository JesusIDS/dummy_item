package com.walmart.mx.dws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Integrator DWS API", version = "1.0", description = "DWS and ItemFile Integration Component"))
public class OptimusApplication {

    public static void main(final String[] args) {
        SpringApplication.run(OptimusApplication.class, args);
    }

}
