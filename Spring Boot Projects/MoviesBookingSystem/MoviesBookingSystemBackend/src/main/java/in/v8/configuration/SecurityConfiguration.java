package in.v8.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/static/**").permitAll() // Allow static resources, React files
//                .requestMatchers("/api/**").permitAll() // Public REST endpoints
                .requestMatchers("/user/**").permitAll() // Public REST endpoints
                .requestMatchers("/admin/**").hasRole("ADMIN") // Restrict admin endpoints, 
                .anyRequest().authenticated() // All other requests require authentication
            );
        return http.build();
    }
}
