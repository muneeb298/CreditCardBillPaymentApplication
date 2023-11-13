package com.cbp.in.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbp.in.entity.Payment;
import com.cbp.in.exceptions.PaymentNotFoundException;
import com.cbp.in.repository.PaymentRepository;
import com.cbp.in.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentrepository;
 
	Payment pmt;
 
	@Override
	public Payment addPayment(Payment payment) {
		paymentrepository.save(payment);
		return payment;
	}
 
	@Override
	public Payment removePayment(long id) {
		if(paymentrepository.existsById(id)) {
			System.out.println("Payment removed successfully");
			Payment p = paymentrepository.findById(id).get();
			paymentrepository.deleteById(id);
			return p;
		}
		else {
			throw new PaymentNotFoundException("Payment Id Not Found");
 
		}

	}
 
	@Override
	public Payment updatePayment(long id, Payment payment) {
		if (paymentrepository.existsById(payment.getPaymentId())) {
 
			return paymentrepository.save(payment);
 
		} else {
 
			throw new PaymentNotFoundException("Payment Id Not Found");
		}
	}
 
	@Override
	public Payment getPayment(long id) {
		if(paymentrepository.existsById(id)) {
		return paymentrepository.findById(id).get();
	}
		else {
			throw new PaymentNotFoundException("Payment Id Not Found");
		}
 
}

}
