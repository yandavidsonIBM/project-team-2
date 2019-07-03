package com.ibm.newhire.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ibm.newhire.model.Customer;
import com.ibm.newhire.service.CustomerService;

import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class RESTController {
	private Logger logger = LoggerFactory.getLogger(RESTController.class);
	
	@Autowired
	private CustomerService customerService;
	
	// Todo Health Check
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findCustomer(@PathVariable(value="id") String id) {
		logger.debug("Entering findCustomer id=" + id);
		Customer customer = null;
		customer = customerService.findById(id); 
		logger.debug("Leaving findCustomer customer=" + customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		logger.debug("Entering addCustomer customer=" + customer);
		customer = customerService.addCustomer(customer);
		logger.debug("Leaving addCustomer customer=" + customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public ResponseEntity<?> getCustomers() {
		logger.debug("Entering getCustomer");
		List<Customer> customer = null;
		customer = customerService.getCustomers();
		logger.debug("Leaving getCustomer");
		return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
	}
}
