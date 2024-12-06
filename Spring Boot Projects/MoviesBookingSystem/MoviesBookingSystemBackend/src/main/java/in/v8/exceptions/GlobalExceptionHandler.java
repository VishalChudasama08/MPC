package in.v8.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.v8.exceptions.custom_exception.UserNotFoundByEmailException;

@ControllerAdvice // Use this annotation for global exception handling 
public class GlobalExceptionHandler { // this class handle all type of exceptions
	
	// Handle validation exceptions like any field black or password not valid...
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
	}
	
	// handle Database Errors like duplicate email
	@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDatabaseErrors(DataIntegrityViolationException ex) {
		Map<String, String> errors = new HashMap<>();
        String shortMessage = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();
        if (shortMessage.contains("Duplicate entry")) {
            // Hardcoded field (can be parsed dynamically if needed)
            errors.put("email", "The provided email is already registered.");
        } else {
        	throw ex; // throw exception and this exception handle by handleGenericException (present in below on this class) 
        }
        return ResponseEntity.badRequest().body(errors);
    }
	
	@ExceptionHandler(UserNotFoundByEmailException.class)
	public ResponseEntity<Map<String, String>> handleUserNotFoundByEmailException(UserNotFoundByEmailException ex){
		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	// Handle generic exceptions (if upper any exception not than handle here, handle all type exception )
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
	    Map<String, String> error = new HashMap<>();
//	    error.put("error", "An unexpected error occurred.");
	    error.put("details", ex.getMessage()); // Optionally include exception details. you on development time
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
}
