package com.cbp.in.exceptions;

public class PaymentNotFoundException extends RuntimeException {
	
	public PaymentNotFoundException(String str)
	{
		super(str);
	}
}
