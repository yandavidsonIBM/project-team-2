package com.ibm.newhire.orderms.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.newhire.orderms.model.Order;
import com.ibm.newhire.orderms.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService
{
	private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	private final OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(final OrderRepository orderRepository)
	{
		this.orderRepository = orderRepository;
	}
	
	@Override
	public Order createOrder(Order order)
	{
		logger.debug("Entered OrderServiceImpl.createOrder. order=" + order);
		order = this.orderRepository.save(order);
		
		logger.debug("Leaving OrderServiceImpl.createOrder. order=" + order);
		return order;
	}
	
	@Override
	public Order retrieveOrderById(String id)
	{
		logger.debug("Entered OrderServiceImpl.retrieveOrderById. id=" + id);
		Order order = this.orderRepository.findById(id);

		logger.debug("Leaving OrderServiceImpl.retrieveOrderById. order=" + order);
		return order;
	}
	
	@Override
	public List<Order> retrieveOrders()
	{
		logger.debug("Entered OrderServiceImpl.retrieveOrders.");
		List<Order> orders = this.orderRepository.findAll();		

		logger.debug("Leaving OrderServiceImpl.retrieveOrders. orders=" + orders);
		return orders;
	}
}
