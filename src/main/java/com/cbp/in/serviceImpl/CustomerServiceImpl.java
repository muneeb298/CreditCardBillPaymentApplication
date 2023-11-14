package com.cbp.in.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbp.in.entity.Customers;
import com.cbp.in.exceptions.CustomerNotFoundException;
import com.cbp.in.repository.CustomerRepository;
import com.cbp.in.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customers addCustomer(Customers customer) {
		
		customerRepository.saveAndFlush(customer);
		
		return customer;
	}

	@Override
	public Customers removeCustomer(long custId) 
	{
		if(!customerRepository.existsById(custId))
		{
			throw new CustomerNotFoundException("Customer not found");
		}
		else 
		{
		Customers c=customerRepository.findById(custId).get();
		
		customerRepository.deleteById(custId);
		
		return c;
	}
	}

	@Override
	public Customers updateCustomer(long custId, Customers customer) {
		
		if(!customerRepository.existsById(custId))
		{
			throw new CustomerNotFoundException("Customer not found");
		}
		else
		{
		
		return customerRepository.save(customer);
	}
	}
	@Override
	public Customers getCustomer(long custId) {
		
		if(!customerRepository.existsById(custId))
		{

			throw new CustomerNotFoundException("Customer not found");
		}
		else {
			
		return customerRepository.findById(custId).get();
	}
	}

	@Override
	public List<Customers>getAllCustomers() {
		
		return customerRepository.findAll();
	}
}
