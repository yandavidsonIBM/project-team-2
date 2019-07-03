package com.ibm.newhire.orderms.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.newhire.orderms.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long>{
	public Order findById(String id);
	public List<Order> findAll();
//	public Order findByCustomerId(String customerId);
}
