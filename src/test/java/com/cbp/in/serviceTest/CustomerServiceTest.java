package com.cbp.in.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cbp.in.entity.Customers;
import com.cbp.in.exceptions.CustomerNotFoundException;
import com.cbp.in.repository.CustomerRepository;
import com.cbp.in.serviceImpl.CustomerServiceImpl;

 
public class CustomerServiceTest {
 
    @Mock
    private CustomerRepository customerRepository;
 
    @InjectMocks
    private CustomerServiceImpl customerService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void testAddCustomer() {
    	
        Customers customerToAdd = new Customers();
        
        when(customerRepository.saveAndFlush(customerToAdd)).thenReturn(customerToAdd);
 
        Customers result = customerService.addCustomer(customerToAdd);
 
        assertEquals(customerToAdd, result);
        verify(customerRepository, times(1)).saveAndFlush(customerToAdd);
    }
 
    @Test
    void testRemoveCustomer() {
    	
        long custIdToRemove = 1L;
        Customers customerToRemove = new Customers();
        when(customerRepository.existsById(custIdToRemove)).thenReturn(true);
        when(customerRepository.findById(custIdToRemove)).thenReturn(Optional.of(customerToRemove));
 
        Customers result = customerService.removeCustomer(custIdToRemove);
 
        assertEquals(customerToRemove, result);
        verify(customerRepository, times(1)).deleteById(custIdToRemove);
    }
 
    @Test
    void testRemoveCustomerNotFound() {
    	
        long custIdToRemove = 1L;
        when(customerRepository.existsById(custIdToRemove)).thenReturn(false);
 
        assertThrows(CustomerNotFoundException.class, () -> customerService.removeCustomer(custIdToRemove));
 
        verify(customerRepository, never()).deleteById(custIdToRemove);
    }
 
    @Test
    void testUpdateCustomer() {
    	
        long custIdToUpdate = 1L;
        Customers customerToUpdate = new Customers();
        when(customerRepository.existsById(custIdToUpdate)).thenReturn(true);
        when(customerRepository.save(customerToUpdate)).thenReturn(customerToUpdate);
 
        Customers result = customerService.updateCustomer(custIdToUpdate, customerToUpdate);
 
        assertEquals(customerToUpdate, result);
    }
 
    @Test
    void testUpdateCustomerNotFound() {
    	
        long custIdToUpdate = 1L;
        Customers customerToUpdate = new Customers();
        when(customerRepository.existsById(custIdToUpdate)).thenReturn(false);
 
        assertThrows(CustomerNotFoundException.class, () -> customerService.updateCustomer(custIdToUpdate, customerToUpdate));
 
        verify(customerRepository, never()).save(customerToUpdate);
    }
 
    @Test
    void testGetCustomer() {
        long custIdToGet = 1L;
        Customers customerToGet = new Customers(/* provide necessary details */);
        when(customerRepository.existsById(custIdToGet)).thenReturn(true);
        when(customerRepository.findById(custIdToGet)).thenReturn(Optional.of(customerToGet));
 
        Customers result = customerService.getCustomer(custIdToGet);
 
        assertEquals(customerToGet, result);
    }
 
    @Test
    void testGetCustomerNotFound() {
    	
        long custIdToGet = 1L;
        when(customerRepository.existsById(custIdToGet)).thenReturn(false);
 
        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomer(custIdToGet));
    }
 
    @Test
    void testGetAllCustomers() {
    	
        List<Customers> customers = new ArrayList<>();
        customers.add(new Customers());
        customers.add(new Customers());
        when(customerRepository.findAll()).thenReturn(customers);
 
        List<Customers> result = customerService.getAllCustomers();
 
        assertEquals(customers, result);
    }
}