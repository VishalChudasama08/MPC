package in.v8.config;

import java.time.Instant;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.boot.autoconfigure.web.ServerProperties.Jetty;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenProvider {
	
	SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
	
	public String generateToken(Authentication authentication) {
		// Set token expiration time (24 hours from now)
        Instant now = Instant.now();
        Instant expiry = now.plusSeconds(86400); // 86400 seconds = 24 hours
        
        // Create JWT token
        String jwt = Jwts.builder()
                .issuer("V8")  // Replaces setIssuer()
                .issuedAt(Date.from(now))  // Replaces setIssuedAt()
                .expiration(Date.from(expiry))  // Replaces setExpiration()
                .claim("email", authentication.getName()) // Add custom claim
                .signWith(key) // Sign with the secret key	
                .compact();
		return jwt;
	}
	
	public String getEmailFromToken(String jwt) {
		// Remove "Bearer " prefix from the token if present
        if (jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7);
        }
        
        // Parse the claims from the JWT
		Claims claims = Jwts.parser()
				.verifyWith(key) // Set the signing key for verification
				.build()
				.parseSignedClaims(jwt) // Parse the token
				.getPayload();
		
		// Extract and return the "email" claim	
		return claims.get("email", String.class);
	}
}
