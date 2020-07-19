package com.cg.bookStore.exceptions;

public class InvalidCategoryNameException extends Exception{

	@Override
	public String toString() {
		return "Invalid Category Name";
	}

	public InvalidCategoryNameException() {
		super();
	}

	public InvalidCategoryNameException(String arg0) {
		super(arg0);		
	}

}
