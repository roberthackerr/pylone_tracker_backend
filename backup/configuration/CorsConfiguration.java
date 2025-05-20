package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
public static final String GET= "GET";
public static final String POST="POST";
public static final String DELETE="DELETE";
public static final String PUT="PUT";
public WebMvcConfigurer CorsConfigurer(){
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                .allowedMethods(GET,PUT,DELETE,POST)
                .allowedHeaders("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                ;
        }
    };
}
}
