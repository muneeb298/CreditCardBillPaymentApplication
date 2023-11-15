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

import com.cbp.in.entity.CreditCard;
import com.cbp.in.exceptions.CreditCardNotFoundException;
import com.cbp.in.repository.CreditCardRepository;
import com.cbp.in.serviceImpl.CreditCardServiceImpl;
 

 
public class CreditCardserviceTest {
 
    @Mock
    private CreditCardRepository creditCardRepository;
 
    @InjectMocks
    private CreditCardServiceImpl creditCardService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void testAddCreditCard() {
    	
        CreditCard creditCardToAdd = new CreditCard(/* provide necessary details */);
        
        when(creditCardRepository.saveAndFlush(creditCardToAdd)).thenReturn(creditCardToAdd);
 
        CreditCard result = creditCardService.addCreditCard(creditCardToAdd);
 
        assertEquals(creditCardToAdd, result);
        verify(creditCardRepository, times(1)).saveAndFlush(creditCardToAdd);
    }
 
    @Test
    void testRemoveCreditCard() {
    	
        long cardIdToRemove = 1L;
        CreditCard creditCardToRemove = new CreditCard(/* provide necessary details */);
        when(creditCardRepository.existsById(cardIdToRemove)).thenReturn(true);
        when(creditCardRepository.findById(cardIdToRemove)).thenReturn(Optional.of(creditCardToRemove));
 
        CreditCard result = creditCardService.removeCreditCard(cardIdToRemove);
 
        assertEquals(creditCardToRemove, result);
        verify(creditCardRepository, times(1)).deleteById(cardIdToRemove);
    }
 
    @Test
    void testRemoveCreditCardNotFound() {
    	
        long cardIdToRemove = 1L;
        when(creditCardRepository.existsById(cardIdToRemove)).thenReturn(false);
 
        assertThrows(CreditCardNotFoundException.class, () -> creditCardService.removeCreditCard(cardIdToRemove));
 
        verify(creditCardRepository, never()).deleteById(cardIdToRemove);
    }
 
    @Test
    void testGetCreditCard() {
    	
        long cardIdToGet = 1L;
        CreditCard creditCardToGet = new CreditCard(/* provide necessary details */);
        when(creditCardRepository.existsById(cardIdToGet)).thenReturn(true);
        when(creditCardRepository.findById(cardIdToGet)).thenReturn(Optional.of(creditCardToGet));
 
        CreditCard result = creditCardService.getCreditCard(cardIdToGet);
 
        assertEquals(creditCardToGet, result);
    }
 
    @Test
    void testGetCreditCardNotFound() {
    	
        long cardIdToGet = 1L;
        when(creditCardRepository.existsById(cardIdToGet)).thenReturn(false);
 
        assertThrows(CreditCardNotFoundException.class, () -> creditCardService.getCreditCard(cardIdToGet));
    }
 
    @Test
    void testGetAllCreditCard() {
    	
        List<CreditCard> creditCards = new ArrayList<>();
        creditCards.add(new CreditCard(/* provide necessary details */));
        creditCards.add(new CreditCard(/* provide necessary details */));
        when(creditCardRepository.findAll()).thenReturn(creditCards);
 
        List<CreditCard> result = creditCardService.getAllCreditCard();
 
        assertEquals(creditCards, result);
    }
 
    @Test
    void testUpdateCreditCard() {
    	
        long cardIdToUpdate = 1L;
        CreditCard creditCardToUpdate = new CreditCard(/* provide necessary details */);
        when(creditCardRepository.existsById(cardIdToUpdate)).thenReturn(true);
        when(creditCardRepository.save(creditCardToUpdate)).thenReturn(creditCardToUpdate);
 
        CreditCard result = creditCardService.updateCreditCard(cardIdToUpdate, creditCardToUpdate);
 
        assertEquals(creditCardToUpdate, result);
    }
 
    @Test
    void testUpdateCreditCardNotFound() {
    	
        long cardIdToUpdate = 1L;
        CreditCard creditCardToUpdate = new CreditCard(/* provide necessary details */);
        when(creditCardRepository.existsById(cardIdToUpdate)).thenReturn(false);
 
        assertThrows(CreditCardNotFoundException.class, () -> creditCardService.updateCreditCard(cardIdToUpdate, creditCardToUpdate));
 
        verify(creditCardRepository, never()).save(creditCardToUpdate);
    }
}