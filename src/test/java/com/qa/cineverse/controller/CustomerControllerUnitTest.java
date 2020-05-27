package com.qa.cineverse.controller;

import com.qa.cineverse.domain.Customers;
import com.qa.cineverse.dto.CustomersDTOTest;
import com.qa.cineverse.service.CustomersService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerUnitTest {

    @InjectMocks
    private CustomersController characterController;

    @Mock
    private CustomersService service;

    private List<Customers> customers;

    private Customers testCustomers;

    private Customers testCustomersWithId;

    private final long id = 1L;

    private CustomersDTOTest customersDTOTest;

    private final ModelMapper mapper = new ModelMapper();

    private CustomersDTOTest mapToDTO(Customers customers){
        return this.mapper.map(customers, CustomersDTOTest.class);
    }

    @Before
    public void setUp(){
        this.customers = new ArrayList<> ();
        this.testCustomers = new Customers ("Luke");
        this.customers.add(testCustomers);
        this.testCustomersWithId = new Customers (testCustomers.getName());
        this.testCustomersWithId.setCustomersId (this.id);
        this.customersDTOTest = this.mapToDTO(testCustomersWithId);
    }

    @Test
    public void getAllCustomersTest(){
        when(service.readCustomers ()).thenReturn(this.customers.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No customer found", this.characterController.getAllCustomers().getBody().isEmpty());
        verify(service, times(1)).readCustomers ();
    }

    @Test
    public void createCustomersTest(){
        when(this.service.createCustomer(testCustomers)).thenReturn(this.customersDTOTest);
        assertEquals(this.characterController.createCharacter(testCustomers), new ResponseEntity<CustomersDTOTest> (this.customersDTOTest, HttpStatus.CREATED));
        verify(this.service, times(1)).createCustomer(testCustomers);
    }

    @Test
    public void deleteCustomersTestFalse(){
        this.characterController.deleteCustomers(id);
        verify(service, times(1)).deleteCustomers(id);
    }

    @Test
    public void getCustomersByIDTest(){
        when(this.service.findCustomersById (id)).thenReturn(this.customersDTOTest);
        assertEquals(this.characterController.getCustomersById (id), new ResponseEntity<CustomersDTOTest>(this.customersDTOTest, HttpStatus.OK));
        verify(service, times(1)).findCustomersById (id);
    }

}
