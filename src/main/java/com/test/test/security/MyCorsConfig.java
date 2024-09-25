package com.test.test.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class MyCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:3000"); // Frontend origin
        corsConfiguration.addAllowedHeader("*"); // Allow all headers
        corsConfiguration.addAllowedMethod("*"); // Allow all HTTP methods (GET, POST, PUT, DELETE)
        corsConfiguration.setAllowCredentials(true); // Allow cookies, authorization headers

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // Apply to all routes

        return new CorsFilter(source);
    }
}
