package com.ibm.newhire.service;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.Mockito;

import com.ibm.newhire.model.Customer;
import com.ibm.newhire.customerms.repo.CustomerRepository;

import java.util.Arrays;
import java.util.List;

public class CustomerServiceImplTest {
	
	@Test
	public void testFindById_customerExists() {
		//Given
		String id = "123";
		String name = "John Doe";
		CustomerRepository customerRepo = Mockito.mock(CustomerRepository.class);
		Customer customer = new Customer(name);
		customer.setId(id);
		when(customerRepo.findById(id)).thenReturn(customer);
		
		
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerRepo);
		
		//When
		Customer foundCustomer = customerServiceImpl.findById(id);
		
		//Then
		assertNotNull("Customer should not be null.", foundCustomer);
		assertTrue("foundBook should equal customer.", foundCustomer.equals(customer));
		verify(customerRepo).findById(id);
	}
	
	@Test
	public void testFindById_customerDoesNotExists() {
		//Given
		String id = "123";
		CustomerRepository customerRepo = Mockito.mock(CustomerRepository.class);
		Customer customer = null;
		when(customerRepo.findById(id)).thenReturn(customer);
		
		
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerRepo);
		
		//When
		Customer foundCustomer = customerServiceImpl.findById(id);
		
		//Then
		assertNull("Customer should be null.", foundCustomer);
		verify(customerRepo).findById(id);
	}
	
	@Test
	public void testFindByName_customerExists() {
		//Given
		String id = "123";
		String name = "John Doe";
		CustomerRepository customerRepo = Mockito.mock(CustomerRepository.class);
		Customer customer = new Customer(name);
		customer.setId(id);
		when(customerRepo.findByName(name)).thenReturn(customer);
		
		
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerRepo);
		
		//When
		Customer foundCustomer = customerServiceImpl.findByName(name);
		
		//Then
		assertNotNull("Customer should not be null.", foundCustomer);
		assertTrue("foundBook should equal customer.", foundCustomer.equals(customer));
		verify(customerRepo).findByName(name);
	}
	
	@Test
	public void testFindByName_customerDoesNotExists() {
		//Given
		String name = "John Doe";
		CustomerRepository customerRepo = Mockito.mock(CustomerRepository.class);
		Customer customer = null;
		when(customerRepo.findByName(name)).thenReturn(customer);
		
		
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerRepo);
		
		//When
		Customer foundCustomer = customerServiceImpl.findByName(name);
		
		//Then
		assertNull("Customer should be null.", foundCustomer);
		verify(customerRepo).findByName(name);
	}
	
	@Test
	public void testAddCustomer() {
		//Given
		String name = "John Doe";
		CustomerRepository customerRepo = Mockito.mock(CustomerRepository.class);
		Customer customer = new Customer(name);
		when(customerRepo.save(customer)).thenReturn(customer);
		
		
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerRepo);
		
		//When
		Customer customerSaved = customerServiceImpl.addCustomer(customer);
		
		//Then
		assertNotNull("Customer should not be null.", customerSaved);
		assertTrue("foundBook should equal customer.", customerSaved.equals(customer));
		verify(customerRepo).save(customer);
	}
	
	@Test
	public void testGetCustomers_manyCustomers() {
		//Given
		String id1 = "123";
		Customer customer1 = new Customer(id1, "John Doe");
		String id2 = "456";
		Customer customer2 = new Customer(id2, "Jane Doe");
		List<Customer> customers = Arrays.asList(customer1, customer2);
		CustomerRepository customerRepo = Mockito.mock(CustomerRepository.class);
		when(customerRepo.findAll()).thenReturn(customers);
		
		
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerRepo);
		
		//When
		List<Customer> foundCustomers = customerServiceImpl.getCustomers();
		
		//Then
		assertNotNull("Customer should not be null.", foundCustomers);
		assertTrue("foundCustomers should equal customers", foundCustomers.equals(customers));
		verify(customerRepo).findAll();
	}
	

	@Test
	public void testGetCustomers_noCustomers() {
		//Given
		List<Customer> customers = Arrays.asList();
		CustomerRepository customerRepo = Mockito.mock(CustomerRepository.class);
		when(customerRepo.findAll()).thenReturn(customers);
		
		
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerRepo);
		
		//When
		List<Customer> foundCustomers = customerServiceImpl.getCustomers();
		
		//Then
		assertNotNull("Customer should not be null.", foundCustomers);
		assertTrue("foundCustomers should equal customers", foundCustomers.equals(customers));
		verify(customerRepo).findAll();
	}
}
