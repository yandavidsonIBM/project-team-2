package com.ibm.newhire.menums.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ibm.newhire.menums.model.Menu;
import com.ibm.newhire.menums.model.MenuItem;
import com.ibm.newhire.menums.repo.MenuItemRepo;
import com.ibm.newhire.menums.repo.MenuRepo;



@Service
public class MenuServiceImpl implements MenuService{
	
	private final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	public MenuServiceImpl(MenuRepo menuRepo) {
		this.menuRepository = menuRepo;
	}
	
	//Added: @Autowired was deleted
	@Autowired
	private MenuItemRepo menuItemRepository;
	
	@Autowired
	private MenuRepo menuRepository;

	@Override
	public Menu findMenuById(String id) {
		logger.debug("Entering findMenuById id=" + id);
		
		Menu menu = this.menuRepository.findById(id);
		if(menu == null) {
			//TODO logger warn.
		}
		
		logger.debug("Leaving findMenuById id=" + id);
		return menu;
	}

	@Override
	public Menu addMenu(Menu menu) {
		
		logger.debug("Entering addMenu menu=" + menu);
		
		menu = this.menuRepository.save(menu);

		logger.debug("Leaving addMenu menu=" + menu);
		
;		return menu;
	}

	@Override
	public void deleteMenuItem(MenuItem menuItem) {
		this.menuItemRepository.delete(menuItem);
		
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		//TODO: Implement
	}
	
	@Override
	public List<MenuItem> getAllMenuItems()
	{
		List<MenuItem> menuItems = this.menuItemRepository.findAll();
		
		return menuItems;
	}
	
	@Override
	 public MenuItem findMenuItem(String name) {
		 MenuItem menuItem = this.menuItemRepository.findByName(name);
		 
		 return menuItem;
	 }
	 
	@Override
	 public MenuItem addMenuItem(MenuItem menuItem) {
		 MenuItem menuItem2 = this.menuItemRepository.insert(menuItem);
		 
		 return menuItem2;
	 }
	
	@Override
	public List<Menu> getAllMenus(){
		logger.debug("Entering getAllMenus");
				
		List<Menu> menus = this.menuRepository.findAll();
		
		logger.debug("Leaving getAllMenus");

		return menus;
		
	}
	
	//added for orderms to call to get menu items from IDs
	public Iterable<MenuItem> findByMenuItemIds(List<Long> menuItemIds) {
		Iterable<MenuItem> menuItems = this.menuItemRepository.findAllById(menuItemIds);
		
		return menuItems;
	}
	
	
}
