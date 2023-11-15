package com.cbp.in.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
 
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cbp.in.entity.Payment;
import com.cbp.in.exceptions.PaymentNotFoundException;
import com.cbp.in.repository.PaymentRepository;
import com.cbp.in.service.PaymentService;
import com.cbp.in.serviceImpl.PaymentServiceImpl;
 

 
@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
 
    @Mock
    private PaymentRepository paymentRepository;
 
    @InjectMocks
    private PaymentService paymentService = new PaymentServiceImpl();
 
    @Test
    public void testAddPayment() {
    
        Payment paymentToAdd = new Payment();
        paymentToAdd.setPaymentId(1L);
        paymentToAdd.setMethod("online");
        paymentToAdd.setAmountDue(974383.0);
 
        when(paymentRepository.save(paymentToAdd)).thenReturn(paymentToAdd);
 
        Payment result = paymentService.addPayment(paymentToAdd);
 
        assertEquals(paymentToAdd, result);
    }
 
    @Test
    public void testUpdatePayment() {
     
        long paymentIdToUpdate = 1L;
 
        Payment updatedPayment = new Payment();
        updatedPayment.setPaymentId(paymentIdToUpdate);
        updatedPayment.setMethod("online");
        updatedPayment.setAmountDue(500.0);
 
        when(paymentRepository.existsById(paymentIdToUpdate)).thenReturn(true);
        when(paymentRepository.save(updatedPayment)).thenReturn(updatedPayment);
 
        Payment result = paymentService.updatePayment(paymentIdToUpdate, updatedPayment);
 
        assertEquals(updatedPayment, result);
    }
 
    @Test
    public void testUpdatePaymentNotFound() {
   
        long nonExistingPaymentId = 999L;
 
        Payment updatedPayment = new Payment();
        updatedPayment.setPaymentId(nonExistingPaymentId);
        updatedPayment.setMethod("online");
        updatedPayment.setAmountDue(500.0);
 
        when(paymentRepository.existsById(nonExistingPaymentId)).thenReturn(false);
 
        assertThrows(PaymentNotFoundException.class, () -> paymentService.updatePayment(nonExistingPaymentId, updatedPayment));
 
        verify(paymentRepository, never()).save(updatedPayment);
    }
 
    @Test
    public void testGetPayment() {
      
        long paymentIdToRetrieve = 1L;
 
        Payment paymentToRetrieve = new Payment();
        paymentToRetrieve.setPaymentId(paymentIdToRetrieve);
        paymentToRetrieve.setMethod("online");
        paymentToRetrieve.setAmountDue(974383.0);
 
        when(paymentRepository.existsById(paymentIdToRetrieve)).thenReturn(true);
        when(paymentRepository.findById(paymentIdToRetrieve)).thenReturn(Optional.of(paymentToRetrieve));
 
        Payment result = paymentService.getPayment(paymentIdToRetrieve);
 
        assertEquals(paymentToRetrieve, result);
    }
 
    @Test
    public void testGetPaymentNotFound() {
       
        long nonExistingPaymentId = 999L;
 
        when(paymentRepository.existsById(nonExistingPaymentId)).thenReturn(false);
 
        assertThrows(PaymentNotFoundException.class, () -> paymentService.getPayment(nonExistingPaymentId));
    }
}