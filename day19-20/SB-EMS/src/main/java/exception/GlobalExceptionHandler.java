package com.coforge.ems.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // to handle global exception
public class GlobalExceptionHandler {

	private Environment environment;

	@Autowired
	public GlobalExceptionHandler(Environment environment) {
		super();
		this.environment = environment;
	}

//	@ExceptionHandler(InvalidEmployeeObjectException.class) // to handle specific exceptions 
//	public ResponseEntity<?> handleInvalidEmployeeObjectException(InvalidEmployeeObjectException e){
//		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler(InvalidEmployeeNotFoundException.class) // to handle specific exceptions
	public ResponseEntity<?> handleInvalidEmployeeNotFoundException(InvalidEmployeeNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("Validation handler called");
//		String error = e.getBindingResult()
//                 .getFieldError()
//                 .getDefaultMessage();
		return new ResponseEntity<>(environment.getProperty("ems.invalid.emp-details"), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class) // to handle specific exceptions
	public ResponseEntity<?> handleException(Exception e) {
		return new ResponseEntity<>(environment.getProperty("ems.db.fail"), HttpStatus.BAD_REQUEST);
	}

}
