package com.corforge.ems.exception;

public class InvalidEmployeeNotFoundException extends Exception {
	
	
	@Override 
	public String toString() {
		return "FAILED : Employee Details Not Found";
	}
}

