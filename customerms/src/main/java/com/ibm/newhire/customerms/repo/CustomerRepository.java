package com.ibm.newhire.customerms.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.newhire.model.Customer;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long>{
	public Customer findById(String id);
	public Customer findByName(String name);
	public List<Customer> findAll();
}
