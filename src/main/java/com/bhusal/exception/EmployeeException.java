package com.bhusal.exception;

public class EmployeeException  extends RuntimeException{
	
	public EmployeeException(Long id) {
		super("Employ is not found with id: " + id);
	}

}
