package com.ibm.newhire.orderms.acceptancetest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ibm.newhire.orderms.model.Order;
import com.ibm.newhire.orderms.repo.OrderRepository;
import com.ibm.newhire.orderms.service.OrderService;
import com.ibm.newhire.orderms.service.OrderServiceImpl;

public class OrderServiceImplTest {
	
	OrderService orderService;
	
	@Mock
	OrderRepository orderRepository;
	
	@Mock
	Order order;
	
	@Mock
	List<Order> orderList;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		orderService = new OrderServiceImpl(orderRepository);
	}

	@Test
	public void testCreateOrder() {
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order, orderService.createOrder(order));
	}

	@Test
	public void testRetrieveOrderById() {
		when(order.getId()).thenReturn("5");
		when(orderRepository.findById(order.getId())).thenReturn(order);
		assertEquals(order, orderService.retrieveOrderById(order.getId()));
	}

	@Test
	public void testRetrieveOrders() {
		when(orderRepository.findAll()).thenReturn(orderList);
		assertEquals(orderList, orderService.retrieveOrders());
	}

}
