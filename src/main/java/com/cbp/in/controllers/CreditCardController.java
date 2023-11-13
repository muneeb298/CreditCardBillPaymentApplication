package com.cbp.in.controllers;
import java.util.List;

import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbp.in.entity.CreditCard;
import com.cbp.in.service.CreditCardService;
 

 
@RestController
@RequestMapping("/creditcardapi")
public class CreditCardController {
 
	@Autowired
	CreditCardService creditCardService;
 
	@PostMapping("/addcreditcard")
	public CreditCard addCreditCard(@Valid @RequestBody CreditCard creditCard) {
 
		return creditCardService.addCreditCard(creditCard);
	}
 
	@GetMapping("/removecreditcard/{cardId}")
	public CreditCard removeCreditCard(@PathVariable("cardId") int cardId) {
		return creditCardService.removeCreditCard(cardId);
	}
 
	@PutMapping("/updatecreditcard/{id}")
	public CreditCard updateCreditCard(@PathVariable("id") int id, @RequestBody CreditCard creditCard) 
	{
		return creditCardService.updateCreditCard(id, creditCard);
	}
	@GetMapping("/getcreditcard/{cardId}")
	public CreditCard getCreditCard(@PathVariable("cardId")int cardId)
	{
		return creditCardService.getCreditCard(cardId);
	}
 
	@GetMapping("/getallcreditcards")
	public List<CreditCard> getAllCreditCard() {
		return creditCardService.getAllCreditCard();
	}
 
}
