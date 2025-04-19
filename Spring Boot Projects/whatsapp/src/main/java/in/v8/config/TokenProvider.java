package in.v8.config;

import java.time.Instant;
import java.util.Date;

import javax.crypto.SecretKey;

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
        
        /** It’s commonly used for authentication and authorization. A JWT consists of three parts, separated by dots (.):
         * Header: Metadata about the token (e.g., the algorithm used). (here issuer(), issuedAt(), expiration())
         * Payload: The actual data (e.g., user info like email or ID). (here called claim())
         * Signature: A cryptographic signature to verify the token’s authenticity. (here signWith())
         * When combined, it looks like this:	header.payload.signature
         * last compact() to separated by dots (.) that jwt make token
         */

        // Create JWT token
        String jwt = Jwts.builder()
                .issuer("V8")  // Replaces setIssuer()
                .issuedAt(Date.from(now))  // set token create date time
                .expiration(Date.from(expiry))  // set token expire time 
                .claim("email", authentication.getName()) // Add custom claim form set email (claim is that data which you won to set in token)
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
		
		// Extract "email" from claim	
		String email = claims.get("email", String.class);
		
		return email;
	}
}
