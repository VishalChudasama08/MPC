package in.v8.configuration;

import java.net.Authenticator;
import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorize -> authorize.requestMatchers("/", "/register").permitAll()
				.anyRequest().authenticated()
				).csrf().disable();
		return http.build();
	}
}
