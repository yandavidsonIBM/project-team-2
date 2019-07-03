package com.ibm.newhire.orderms.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.newhire.orderms.model.Order;
import com.ibm.newhire.orderms.service.OrderService;

@RestController
public class OrderRESTController {
	private Logger logger = LoggerFactory.getLogger(OrderRESTController.class);
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/health")
	public String health() {
		//TODO
		return "health";
	}

	@GetMapping("/order")
	public ResponseEntity<?> retrieveOrders() {
		logger.debug("Entering retrieveOrders");
		List<Order> orders = orderService.retrieveOrders();
		logger.debug("Leaving retrieveOrders");
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);		
	}

	@GetMapping("/order/{orderID}")
	public ResponseEntity<?> retrieveOrderById(@PathVariable String orderID) {
		logger.debug("Entering retrieveOrderById id=" + orderID);
		Order order = orderService.retrieveOrderById(orderID);
		logger.debug("Leaving retrieveOrderById id=" + orderID);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	

	@PostMapping("/order")
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		logger.debug("Entering createOrder order=" + order);
		order = orderService.createOrder(order);
		logger.debug("Leaving createOrder order=" + order);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

}
