package com.databankgroup.gh.accopeningapi;

import org.keycloak.adapters.springboot.KeycloakAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AccopeningapiApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AccopeningapiApplication.class);
    }

    public static void main(String[] args) {
		SpringApplication.run(AccopeningapiApplication.class, args);
	}
}
