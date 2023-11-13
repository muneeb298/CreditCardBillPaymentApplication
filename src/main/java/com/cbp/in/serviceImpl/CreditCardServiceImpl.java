package com.cbp.in.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbp.in.entity.CreditCard;
import com.cbp.in.exceptions.CreditCardNotFoundException;
import com.cbp.in.repository.CreditCardRepository;
import com.cbp.in.service.CreditCardService;
@Service
public class CreditCardServiceImpl implements CreditCardService {
	@Autowired
	CreditCardRepository creditcardrepository;
 
	@Override
	public CreditCard addCreditCard(CreditCard creditcard) {
		creditcardrepository.saveAndFlush(creditcard);
		return creditcard;
	}
 
	@Override
	public CreditCard removeCreditCard(long cardId) {
		if(creditcardrepository.existsById(cardId))
		{
		CreditCard c = creditcardrepository.findById(cardId).get();
		creditcardrepository.deleteById(cardId);
		return c;
		}
		else
		{
			throw new CreditCardNotFoundException("No Credit Card with given Id");
		}
	}
 
 
	@Override
	public CreditCard getCreditCard(long cardId) {
		if(creditcardrepository.existsById(cardId))
		{
		return creditcardrepository.findById(cardId).get();
		}
		else
		{
			throw new CreditCardNotFoundException("No Credit Card with given Id");
		}
	}
 
	@Override
	public List<CreditCard> getAllCreditCard() {
		return creditcardrepository.findAll();
	}
 
	@Override
	public CreditCard updateCreditCard(long cardId, CreditCard creditcard) {
		if(creditcardrepository.existsById(cardId))
		{
			return creditcardrepository.save(creditcard);
		}
		else
		{
			throw new CreditCardNotFoundException("No Credit Card with given Id");	
		}
	}
	

}
