package com.ibm.newhire.orderms.service;

import java.util.List;

import com.ibm.newhire.orderms.model.Order;

public interface OrderService
{
	public Order createOrder(Order order);
	public Order retrieveOrderById(String id);
	public List<Order> retrieveOrders();
}
