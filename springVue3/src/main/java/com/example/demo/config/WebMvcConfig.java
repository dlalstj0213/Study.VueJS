package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET","POST","PUT","PATCH","DELETE","HEAD","OPTIONS")
//                .allowedOrigins("*", "http://192.168.0.143:8081")
                .allowedOriginPatterns("*", "http://192.168.0.1:8081", "http://192.168.0.143:8081")
                .allowCredentials(true);
    }


}
