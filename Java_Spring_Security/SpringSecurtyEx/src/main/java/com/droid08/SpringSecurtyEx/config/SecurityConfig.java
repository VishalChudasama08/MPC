package com.droid08.SpringSecurtyEx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                    .csrf(customizer -> customizer.disable()) // disable csrf. because it enable then without token post, put, delete requests are not allowed.
                    .authorizeHttpRequests(request -> request.anyRequest().authenticated()) // not allowed any types of request
                    .httpBasic(Customizer.withDefaults()) // request.anyRequest().authenticated() this not allowed any request than, this line .httpBasic(Customizer.withDefaults()) allowed default login form.
                                                         // user login than allowed all requests (in postman basic auth user/password set than allowed), without login not allow.
                                                        // one time login than session managed (means in browser tab you are logged in. but different browser you are not logged in)
                    .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    ) // this line avery request change session id to manage session.
                    .build();
    }
}
