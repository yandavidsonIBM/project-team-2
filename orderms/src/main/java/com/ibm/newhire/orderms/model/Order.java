package com.ibm.newhire.orderms.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Orders")
public class Order {
	
	@Id
	private String id;
	
	private BigInteger customerId;
	private List<OrderItem> listOfOrderItems;
	
	
	public Order(BigInteger customerId, List<OrderItem> listOfOrderItems) {
		setCustomerId(customerId);
		setListOfOrderItems(listOfOrderItems);
	}
	
	public void deleteOrderItem(OrderItem orderItem) {
		if(listOfOrderItems == null) return;
		this.listOfOrderItems.remove(orderItem);
	}
	
	public void addOrderItem(OrderItem orderItem) {
		if(listOfOrderItems == null) {
			listOfOrderItems = new ArrayList<OrderItem>();
		}
		this.listOfOrderItems.add(orderItem);
	}
	
	public BigInteger getCustomerId() {
		return customerId;
	}
	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}
	public List<OrderItem> getListOfOrderItems() {
		return listOfOrderItems;
	}
	public void setListOfOrderItems(List<OrderItem> listofOrderItems) {
		this.listOfOrderItems = listofOrderItems;
	}
	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listOfOrderItems == null) ? 0 : listOfOrderItems.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listOfOrderItems == null) {
			if (other.listOfOrderItems != null)
				return false;
		} else if (!listOfOrderItems.equals(other.listOfOrderItems))
			return false;
		return true;
	}
}

