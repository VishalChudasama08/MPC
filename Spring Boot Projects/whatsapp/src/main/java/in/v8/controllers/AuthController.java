package in.v8.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.v8.config.TokenProvider;
import in.v8.entities.User;
import in.v8.exceptions.UserException;
import in.v8.repositores.UserRepository;
import in.v8.request.LoginRequest;
import in.v8.response.AuthResponse;
import in.v8.services.CustomUserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private TokenProvider tokenProvider;
	private CustomUserService customUserService;
	
	public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenProvider tokenProvider, CustomUserService customUserService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.tokenProvider = tokenProvider;
		this.customUserService = customUserService;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
		String email = user.getEmail();
		String fullname = user.getFullName();
		String password = user.getPassword();
		
		User isUser = userRepository.findByEmail(email);
		if(isUser != null) {
			throw new UserException("Email is used with another account " + email);
		}
		
		User createUser = new User();
		createUser.setEmail(email);
		createUser.setFullName(fullname);
		createUser.setPassword(passwordEncoder.encode(password));
		
		userRepository.save(createUser);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = tokenProvider.generateToken(authentication);
		
		AuthResponse response = new AuthResponse(token, true);
		return new ResponseEntity<AuthResponse>(response, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<AuthResponse> loginHandler(@RequestBody LoginRequest request){
		String email = request.getEmail();
		String password = request.getPassword();
		
		Authentication authentication = authentication(email, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = tokenProvider.generateToken(authentication);
		
		AuthResponse response = new AuthResponse(token, true);
		return new ResponseEntity<AuthResponse>(response, HttpStatus.ACCEPTED);
	}
	
	public Authentication authentication(String usename, String password) {
		UserDetails userDetails = customUserService.loadUserByUsername(usename);
		
		if(userDetails == null) {
			throw new BadCredentialsException("Invalid username ");
		}
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid password or username");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}
}
