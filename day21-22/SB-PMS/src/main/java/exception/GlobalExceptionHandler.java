package com.coforge.pms.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
	private Environment environment;

	@Autowired
	public GlobalExceptionHandler(Environment environment) {
		super();
		this.environment = environment;
	}
	
	
//	@ExceptionHandler(InvalidProductObjectException.class) // to handle specific exceptions 
//	public ResponseEntity<?> handleInvalidEmployeeObjectException(InvalidProductObjectException e){
//		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(ProductNotFoundException.class) // to handle specific exceptions 
	public ResponseEntity<?> handleEmployeeNotFoundException(ProductNotFoundException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
//		System.out.println("Validation handler called"); 
//		String error = e.getBindingResult()
//                 .getFieldError()
//                 .getDefaultMessage();
		return new ResponseEntity<>(environment.getProperty("pms.invalid.pms-details"),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class) // to handle specific exceptions 
	public ResponseEntity<?> handleException(Exception e){
		return new ResponseEntity<>(environment.getProperty("psm.db.fail"),HttpStatus.BAD_REQUEST);
	}
	
	
}
