package com.ibm.newhire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}