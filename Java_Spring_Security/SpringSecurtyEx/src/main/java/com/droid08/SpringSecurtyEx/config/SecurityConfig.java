package com.droid08.SpringSecurtyEx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                    .csrf(customizer -> customizer.disable()) // disable csrf. without csrf token get, post, put, delete requests not work. then disable it
                    .authorizeHttpRequests(request -> request.anyRequest().authenticated()) // not allowed any types of request
                    .httpBasic(Customizer.withDefaults()) // request.anyRequest().authenticated() this not allowed any request than, this line .httpBasic(Customizer.withDefaults()) allowed default login form. user login than allowed all requests (in postman basic auth user/password set than allowed), without login not allow. one time login than session managed (means in browser tab you are logged in. but different browser you are not logged in)
                    .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    ) // this line change session id in avery request/reload to manage session.
                    .build();
    }


    // not use default username and password (see in application.properties file)
    // use username and password set by user. verify than username and password

    // in this method. still not get user details from database. this is hardcode values
    @Bean
    public UserDetailsService userDetailsService(){

        // by verify postman login with user 1 details request
        UserDetails user1 = User
                                .withDefaultPasswordEncoder()
                                .username("vishal")
                                .password("12345")
                                .roles("ADMIN")
                                .build();

        // by verify postman 'login with user 2 details request
        UserDetails user2 = User
                                .withDefaultPasswordEncoder()
                                .username("vishal2")
                                .password("54321")
                                .roles("USER")
                                .build();

        return new InMemoryUserDetailsManager(user1, user2); // send user object in arguments
    }
}
