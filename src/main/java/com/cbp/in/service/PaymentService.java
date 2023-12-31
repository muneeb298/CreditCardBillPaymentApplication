package com.cbp.in.service;

import com.cbp.in.entity.Payment;

public interface PaymentService {
	
	public Payment addPayment(Payment payment);
	
	public Payment removePayment(long id);
	
	public Payment updatePayment(long id, Payment payment);
	
	public Payment getPayment(long id);

}
