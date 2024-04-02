package com.bhusal.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployGlobalExHandler {
	
	// this will deal when employ with given id do not exit
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<?> handleEmpNotFound(EmployeeException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	// this will handle validation of the class variables
	public ResponseEntity<?> handleValidationEx(MethodArgumentNotValidException ex){
		// define a maps
		Map<String, Object> body = new HashMap<>();
		Map<String, Object> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
		body.put("timeStamp", LocalDateTime.now());
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("errors", errors);
		return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
		
	}

}
