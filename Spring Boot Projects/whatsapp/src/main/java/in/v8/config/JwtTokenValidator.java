package in.v8.config;

import java.io.IOException;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenValidator extends OncePerRequestFilter {

    /**
     * Validates the incoming JWT token from the Authorization header.
     * 
     * @param request      The HTTP servlet request.
     * @param response     The HTTP servlet response.
     * @param filterChain  The filter chain for passing the request forward.
     * @throws ServletException if an error occurs during filtering.
     * @throws IOException      if an I/O error occurs during filtering.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String jwt = request.getHeader("Authorization");
        if (jwt != null) {
            try {
                // Remove "Bearer " prefix from the token.
                jwt = jwt.substring(7);

                // Create a SecretKey using the predefined secret key.
                SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

                // Parse and validate the JWT token.
                Claims claims = Jwts.parser()  // https://stackoverflow.com/questions/78805779/issue-with-parserbuilder-method-in-jjwt-library-for-jwt-token-validation
                	    .verifyWith(key) // Validate using the signing key.
                	    .build() // Build the JwtParser instance.
                	    .parseSignedClaims(jwt) // Parse the JWT and retrieve signed claims.
                	    .getPayload(); // Extract the payload.

                // Extract information from the claims.
                String email = String.valueOf(claims.get("email"));
                String authorities = String.valueOf(claims.get("authorities"));

                // Convert authorities into a list of GrantedAuthority objects.
                List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);

                // Create an Authentication object and set it in the SecurityContext.
                Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, auths);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                // Handle invalid token scenario.
                throw new BadCredentialsException("Invalid Token Received.", e);
            }
        }

        // Continue the filter chain.
        filterChain.doFilter(request, response);
    }
}
