package com.example.vendor.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.vendor.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFound(ResourceNotFoundException ex) {
		Map<String, Object> error = new HashMap<>();
		error.put("timestamp", LocalDateTime.now());
		error.put("status", HttpStatus.NOT_FOUND.value());
		error.put("error", "Not Found");
		error.put("message", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	 @ExceptionHandler(DataIntegrityViolationException.class)
	    public ResponseEntity<Map<String, String>> handleDuplicateEmail(DataIntegrityViolationException ex) {
	        Map<String, String> response = new HashMap<>();
	        response.put("error", "Email already exists. Please use another email.");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    }

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleGenericExceptions(Exception ex) {
		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

}