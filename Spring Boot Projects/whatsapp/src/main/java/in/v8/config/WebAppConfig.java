package in.v8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class WebAppConfig {

	// Configures the security filter chain for the application.
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            // Disable CSRF for simplicity; enable it in production environments for enhanced security.
            .csrf(csrf -> csrf.disable())
            // Configure the session management policy as stateless.
            .sessionManagement(sessionManagement -> 
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // Apply Cross-Origin Resource Sharing (CORS) settings.
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            // Define endpoint-specific authorization rules.
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(new AntPathRequestMatcher("/api/**")).authenticated() // Secure /api/** endpoints.
                .anyRequest().permitAll() // Permit access to all other endpoints.
            )
            // Configure form-based login for default login handling.
            .formLogin(formLogin -> formLogin.permitAll())
            // Add a custom filter to validate JWT tokens.
            .addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class);

        return httpSecurity.build();
    }

    // Define CORS configuration
    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000")); // Allow React app
            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            configuration.setAllowCredentials(true); // Allow cookies and credentials.
            configuration.setAllowedHeaders(Collections.singletonList("*")); // Allow all headers.
            configuration.setExposedHeaders(Collections.singletonList("Authorization")); // Expose the Authorization header.
            configuration.setMaxAge(3600L); // Cache CORS configuration for 1 hour
            return configuration;
        };
    }

    // Define password encoder
    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
