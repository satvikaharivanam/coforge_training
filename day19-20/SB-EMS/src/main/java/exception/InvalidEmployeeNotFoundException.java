package com.coforge.ems.exception;

public class InvalidEmployeeNotFoundException extends RuntimeException {
	
	public InvalidEmployeeNotFoundException (String errorMessage) {
		super(errorMessage);
	}
}

