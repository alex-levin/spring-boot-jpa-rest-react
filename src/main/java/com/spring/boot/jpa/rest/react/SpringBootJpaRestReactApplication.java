package com.spring.boot.jpa.rest.react;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.spring.boot.jpa.rest.react.model"})
public class SpringBootJpaRestReactApplication {
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = SpringApplication.run(SpringBootJpaRestReactApplication.class, args);
	}
}
