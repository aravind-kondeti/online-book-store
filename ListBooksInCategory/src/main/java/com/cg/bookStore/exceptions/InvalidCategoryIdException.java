package com.cg.bookStore.exceptions;

public class InvalidCategoryIdException extends Exception {
	
	@Override
	public String toString() {
		return "Invalid Category Id";
	}
	
	public InvalidCategoryIdException() {
		super();
	}

	public InvalidCategoryIdException(String arg0) {
		super(arg0);		
	}
	
}
