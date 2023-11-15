package com.cbp.in.serviceTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
 
import java.time.LocalDate;
 
import javax.validation.ConstraintViolationException;
 
import org.junit.jupiter.api.Test;

import com.cbp.in.entity.Customers;
import com.cbp.in.entity.Statement;
 

 
public class StatementServiceTest {
 
    @Test
    public void testStatementFields() {
        
        long statementId = 1;
        double dueAmount = 1500.0;
        LocalDate billingDate = LocalDate.now();
        LocalDate dueDate = LocalDate.now().plusDays(30);
        Customers customer = new Customers();
 
      
        Statement statement = new Statement(statementId, dueAmount, billingDate, dueDate, customer);
 
       
        assertEquals(statementId, statement.getStatementId());
        assertEquals(dueAmount, statement.getDueAmount());
        assertEquals(billingDate, statement.getBillingDate());
        assertEquals(dueDate, statement.getDueDate());
        assertEquals(customer, statement.getCustomers());
    }
 
    @Test
    public void testStatementToStringMethod() {
        
        long statementId = 1;
        double dueAmount = 1500.0;
        LocalDate billingDate = LocalDate.now();
        LocalDate dueDate = LocalDate.now().plusDays(30);
        Customers customer = new Customers();
 
        Statement statement = new Statement(statementId, dueAmount, billingDate, dueDate, customer);
   
        String result = statement.toString();
 
        String expected = "Statement [statementId=" + statementId + ", dueAmount=" + dueAmount + ", billingDate="
                + billingDate + ", dueDate=" + dueDate + ", customers=" + customer + "]";
        assertEquals(expected, result);
    }
 
    @Test
    public void testStatementDueAmountValidation() {
     
        long statementId = 1;
        double invalidDueAmount = 500.0; // less than the required minimum value
        LocalDate billingDate = LocalDate.now();
        LocalDate dueDate = LocalDate.now().plusDays(30);
        
        Customers customer = new Customers();
 
        assertDoesNotThrow(() -> {
            new Statement(statementId, invalidDueAmount, billingDate, dueDate, customer);
        }, "Expected no exception to be thrown");
    }
}
