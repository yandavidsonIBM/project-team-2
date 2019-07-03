package com.ibm.newhire.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ibm.newhire.customerms.repo.CustomerRepository;
import com.ibm.newhire.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	private CustomerRepository customerRepo;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	@Override
	public Customer findById(String id) {
		logger.debug("Entering findById. id=" + id.toString());
		Customer customer = customerRepo.findById(id);
		logger.debug("Leaving findById. customer=" + customer);
		return customer;
	}
	
	@Override
	public Customer findByName(String name) {
		logger.debug("Entering findByName. name=" + name);
		Customer customer = customerRepo.findByName(name);
		logger.debug("Leaving findByName. customer=" + customer);
		return customer;
	}
	
	@Override
	public Customer addCustomer(Customer customer) {
		logger.debug("Entering findByName. customer=" + customer);
		customer = customerRepo.save(customer);
		logger.debug("Leaving findByName. customer=" + customer);
		return customer;
	}
	
	@Override
	public List<Customer> getCustomers() {
		logger.debug("Entering getCustomers");
		List<Customer> customers = null;
		customers = customerRepo.findAll();
		logger.debug("Leaving getCustomers customers=" + customers);
		return customers;
	}
}
