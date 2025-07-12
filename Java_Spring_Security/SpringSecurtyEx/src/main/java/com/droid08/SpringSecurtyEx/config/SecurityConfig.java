package com.droid08.SpringSecurtyEx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                    .csrf(customizer -> customizer.disable()) // disable csrf. because it enable then without token post, put, delete requests are not allowed.
                    .authorizeHttpRequests(request -> request.anyRequest().authenticated()) // how to do this line:- If you are not logged in, you cannot access any endpoint.
                                                                                           // If you access any endpoint without logging in, you get a 401 Unauthorized (for HTTP Basic)
                    .httpBasic(Customizer.withDefaults()) // request.anyRequest().authenticated() this not allowed any request than, this line .httpBasic(Customizer.withDefaults()) allowed default login form.
                                                         // user login than allowed all requests (in postman basic auth user/password set than allowed), without login not allow.
                                                        // one time login than session managed (means in browser tab you are logged in. but different browser you are not logged in)
                    .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    ) // this line avery request change session id to manage session.
                    .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
}
