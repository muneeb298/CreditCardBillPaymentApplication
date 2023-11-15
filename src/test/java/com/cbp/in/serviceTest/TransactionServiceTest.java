package com.cbp.in.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
 
import java.time.LocalDate;
 
import org.junit.jupiter.api.Test;

import com.cbp.in.entity.Customers;
import com.cbp.in.entity.Transaction;
 
 
public class TransactionServiceTest {
 
    @Test
    public void testTransactionFields() {
   
        long transId = 1;
        String cardNumber = "1234567890123456";
        LocalDate tranDate = LocalDate.now();
        String status = "Success";
        double amount = 100.0;
        String paymentMethod = "Credit Card";
        String description = "Transaction Description";
       
        Transaction transaction = new Transaction(transId, cardNumber, tranDate, status, amount, paymentMethod,
                description, null);
 
    
        assertEquals(transId, transaction.getTransId());
        assertEquals(cardNumber, transaction.getCardNumber());
        assertEquals(tranDate, transaction.getTranDate());
        assertEquals(status, transaction.getStatus());
        assertEquals(amount, transaction.getAmount());
        assertEquals(paymentMethod, transaction.getPaymentMethod());
        assertEquals(description, transaction.getDescription());
    }
 
    @Test
    public void testToStringMethod() {
     
        long transId = 1;
        String cardNumber = "1234567890123456";
        LocalDate tranDate = LocalDate.now();
        String status = "Success";
        double amount = 100.0;
        String paymentMethod = "Credit Card";
        String description = "Transaction Description";
        
        Transaction transaction = new Transaction(transId, cardNumber, tranDate, status, amount, paymentMethod,
                description, null);
 
      
        String result = transaction.toString();
 
        String expected = "Transaction [transId=" + transId + ", cardNumber=" + cardNumber + ", tranDate=" + tranDate
                + ", status=" + status + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", description="
                + description + "]";
        
        assertEquals(expected, result);
    }
}