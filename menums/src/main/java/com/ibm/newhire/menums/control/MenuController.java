package com.ibm.newhire.menums.control;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.newhire.menums.model.Menu;
import com.ibm.newhire.menums.model.MenuItem;
import com.ibm.newhire.menums.service.MenuService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;


@RestController
public class MenuController {
	private final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	public MenuController() {
		
	}
	
	
	@GetMapping("/menu/{name}")
	public ResponseEntity<?> findMenu(@PathVariable(value="name")String id){
		logger.debug("Entering findMenu name=" + id);
		Menu menu = this.menuService.findMenuById(id);
		logger.debug("Leaving findMenu menu=" + menu);
		return new ResponseEntity<Menu>(menu, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/menu/add", method=RequestMethod.POST)
	public ResponseEntity<?> addMenu(@RequestBody Menu menu) {
		logger.debug("Entering addMenu menu=" + menu);
		menu = this.menuService.addMenu(menu);
		logger.debug("Leaving addMenu menu=" + menu);
		return new ResponseEntity<Menu>(menu, HttpStatus.OK);
	}
	
	
	// TODO Add menu ID
	@GetMapping("/menu")
	public ResponseEntity<?> getMenuItems() {
		logger.debug("Entering getMenuItems");
		List<MenuItem> menuItems = this.menuService.getAllMenuItems();
		logger.debug("Leaving getMenuItems menuItems=" + menuItems);
		return new ResponseEntity<List<MenuItem>> (menuItems, HttpStatus.OK);
	}
	
	// TODO Add menu ID
	@GetMapping("/menu/menuItem/{name}")
	public ResponseEntity<?> findMenuItem(@PathVariable(value="name") String name) {
		logger.debug("Entering findMenuItem name=" + name);
		MenuItem menuItem = this.menuService.findMenuItem(name);
		logger.debug("Leaving findMenuItem menuItems=" + menuItem);
		return new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
	}

	@PostMapping("/menu/menuItem/add")
	public ResponseEntity<?> addMenuItem(@RequestBody MenuItem menuItem) {
		logger.debug("Entering addMenuItem menuItem=" + menuItem);
		menuItem = this.menuService.addMenuItem(menuItem);
		logger.debug("Leaving findMenuItem menuItem=" + menuItem);
		return new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
	}
	
	// TODO Add menu ID
	@DeleteMapping("/menu/deleteItem")
	public ResponseEntity<?> deleteMenu(@RequestBody MenuItem menuItem){
		logger.debug("Entering deleteMenu menuItem=" + menuItem);
		this.menuService.deleteMenuItem(menuItem);
		logger.debug("Entering deleteMenu menuItem=" + menuItem);
		return new ResponseEntity<String> ("Deleted", HttpStatus.OK);
	}
	
	//added for orderms to call to get menu items from IDs
	@GetMapping("/menu/menuItems/{ids}")
	public ResponseEntity<?> getMenuItemsByIds(@PathVariable(value="ids") List<Long> menuItemIds) {
		
		
		Iterable<MenuItem> menuItems = this.menuService.findByMenuItemIds(menuItemIds);
		
		return new ResponseEntity<Iterable<MenuItem>>(menuItems, HttpStatus.OK);
	}
	
	
}