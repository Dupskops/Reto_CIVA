package com.apibus.spring.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 
            // Permisos
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/bus/**").permitAll() // Publico el endpoint /bus/**
                .anyRequest().authenticated() // Otra ruta requiere autenticacion
            );
            
        return http.build();
    }
}
