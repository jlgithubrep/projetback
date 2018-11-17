package com.example.demo.security;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
@Override
public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
		.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH","OPTIONS")
		.allowedHeaders("*")
		.exposedHeaders("WWW-Authenticate")
		.allowCredentials(true)
		.allowedOrigins("*")
		.maxAge(TimeUnit.DAYS.toSeconds(1));
	}
}
