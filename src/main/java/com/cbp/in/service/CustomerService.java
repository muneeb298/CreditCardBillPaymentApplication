package com.cbp.in.service;

import java.util.List;

import com.cbp.in.entity.Customers;


public interface CustomerService {
	
	public Customers addCustomer(Customers customer);
	public Customers removeCustomer(long custId);
	public Customers updateCustomer(long custId,Customers customer);
	public Customers getCustomer(long custId);
	public List<Customers> getAllCustomers();

}
