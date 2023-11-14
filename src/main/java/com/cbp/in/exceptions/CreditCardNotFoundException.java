package com.cbp.in.exceptions;

public class CreditCardNotFoundException extends RuntimeException {
	
	public CreditCardNotFoundException(String str)
	{
		super(str);
	}
}

