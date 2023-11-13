package com.cbp.in.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cbp.in.exceptions.TransactionNotFoundException;


@ControllerAdvice
public class TransactionExceptionController {
	
	@ExceptionHandler(value=TransactionNotFoundException.class)
	public ResponseEntity<Object> exceptionHandler(Exception ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	

}