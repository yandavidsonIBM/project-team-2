package com.ibm.newhire.orderms.model;

import java.math.BigInteger;

public class OrderItem {

	
	private BigInteger menuItemId;
	private int quantity;
	
	public OrderItem(BigInteger menuItemId, int quantity) {
		setMenuItemId(menuItemId);
		setQuantity(quantity);
	}
	
	public BigInteger getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(BigInteger menuItemId) {
		this.menuItemId = menuItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuItemId == null) ? 0 : menuItemId.hashCode());
		result = prime * result + quantity;
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
		OrderItem other = (OrderItem) obj;
		if (menuItemId == null) {
			if (other.menuItemId != null)
				return false;
		} else if (!menuItemId.equals(other.menuItemId))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
}
