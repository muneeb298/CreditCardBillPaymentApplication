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

import com.cbp.in.entity.Customers;
import com.cbp.in.service.CustomerService;


@RestController
@RequestMapping("/customerapi")
public class CustomerController
{
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addcustomer")
	public  Customers addCustomer(@Valid @RequestBody Customers customer)
	{
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/removecustomer/{custId}")
	public Customers removeCustomer(@PathVariable("custId")long custId)
	{
		return  customerService.removeCustomer(custId);
	}
	@PutMapping("/updatecustomer/{custId}")
	public Customers updateCustomer(@PathVariable("custId")long custId,@Valid @RequestBody Customers customer)
	{
		return customerService.updateCustomer(custId,customer);
	}
	@GetMapping("/getcustomer/{custId}")
	public Customers getCustomer(@PathVariable("custId")long custId)
	{
		return customerService.getCustomer(custId);
	}
	@GetMapping("/getallcustomers")
	public List<Customers>getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
}