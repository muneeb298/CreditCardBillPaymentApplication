package com.cbp.in.exceptions;


public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String str)
	{
		super(str);
	}

}