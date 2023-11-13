package com.cbp.in.service;

import java.util.List;

import com.cbp.in.entity.CreditCard;

public interface CreditCardService {
	
	public CreditCard addCreditCard(CreditCard creditcard);
	 
	public CreditCard removeCreditCard(long cardId);
 
	public CreditCard updateCreditCard(long cardId,CreditCard creditCard);
 
	public CreditCard getCreditCard(long carId);
 
	public List<CreditCard> getAllCreditCard();

}
