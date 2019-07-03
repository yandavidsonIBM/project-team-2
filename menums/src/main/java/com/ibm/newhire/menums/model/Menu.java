package com.ibm.newhire.menums.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Menus")
public class Menu {
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String name;
	
	@DBRef
	private List<MenuItem> menuItems;
	
	
	
	public Menu() {
		super();
	}
	

	
	public Menu(String id, String name, List<MenuItem> menutItems) {
		super();
		this.id = id;
		this.name = name;
		this.menuItems = menuItems;
	}
	
	public void addMenuItem(MenuItem menuItem) {
		if(this.menuItems == null) {
			this.menuItems = new ArrayList<MenuItem>();
		}
		this.menuItems.add(menuItem);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((menuItems == null) ? 0 : menuItems.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Menu other = (Menu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (menuItems == null) {
			if (other.menuItems != null)
				return false;
		} else if (!menuItems.equals(other.menuItems))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", menuItems=" + menuItems + "]";
	}
	
	
	
}
