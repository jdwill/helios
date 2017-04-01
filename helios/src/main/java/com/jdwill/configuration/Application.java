package com.jdwill.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Initializes Spring Boot
 * @author Jason Williams
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.jdwill"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}
}