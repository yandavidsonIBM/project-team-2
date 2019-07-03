package com.ibm.newhire.service;

import java.util.List;

import com.ibm.newhire.model.Customer;

public interface CustomerService {
	public Customer findById(String id);
	public Customer findByName(String name);
	public Customer addCustomer(Customer customer);
	public List<Customer> getCustomers();
}
