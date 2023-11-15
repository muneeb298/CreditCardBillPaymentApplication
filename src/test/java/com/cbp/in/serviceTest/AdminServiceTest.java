package com.cbp.in.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cbp.in.entity.Admin;
import com.cbp.in.entity.User;
import com.cbp.in.repository.AdminRepository;
import com.cbp.in.serviceImpl.AdminServiceImpl;
 

 
public class AdminServiceTest {
 
    @Mock
    private AdminRepository adminRepository;
 
    @InjectMocks
    private AdminServiceImpl adminService;
 
    @BeforeEach
    public void setUp() {
    	
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testAddAdminWithValidPassword() {
      
        User userWithValidPassword = new User();
        
        userWithValidPassword.setPassword("ValidPassword123!");
 
        Admin admin = new Admin();
        
        admin.setUser(userWithValidPassword);
 
        
        when(adminRepository.save(admin)).thenReturn(admin);
 
       
        String result = adminService.addAdmin(admin);
 
      
        assertEquals("admin added sucessfully", result);
        verify(adminRepository, times(1)).save(admin);
    }
 
    @Test
    public void testAddAdminWithInvalidPassword() {
      
        User userWithInvalidPassword = new User();
        userWithInvalidPassword.setPassword("invalid");
 
        Admin admin = new Admin();
        admin.setUser(userWithInvalidPassword);
 
       
        String result = adminService.addAdmin(admin);
 
        
        assertEquals("Password not according to rules", result);
        verify(adminRepository, never()).save(admin);
    }
 
    @Test
    public void testAddAdminWithPatternMismatchPassword() {
       
        User userWithPatternMismatchPassword = new User();
        userWithPatternMismatchPassword.setPassword("weakpassword");
 
        Admin admin = new Admin();
        admin.setUser(userWithPatternMismatchPassword);
 
        
        String result = adminService.addAdmin(admin);
 
        
        assertEquals("Password not according to rules", result);
        verify(adminRepository, never()).save(admin);
    }
 
 
 
}