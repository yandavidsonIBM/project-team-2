package com.ibm.newhire.menums.service;


import java.math.BigInteger;
import java.util.List;

import org.bson.types.ObjectId;

import com.ibm.newhire.menums.model.Menu;
import com.ibm.newhire.menums.model.MenuItem;

public interface MenuService {
	//Menu
 public Menu findMenuById(String id);
 public Menu addMenu(Menu menu);
 public List<Menu> getAllMenus();
 public void updateMenu(Menu menu);
 
 
 //MenuItems
 public List<MenuItem> getAllMenuItems();
 public MenuItem findMenuItem(String name);
 public MenuItem addMenuItem(MenuItem menuItem);
 public void deleteMenuItem(MenuItem menuItem);
 
 // Added
 public Iterable<MenuItem> findByMenuItemIds(List<Long> menuItemIds);
 
}
