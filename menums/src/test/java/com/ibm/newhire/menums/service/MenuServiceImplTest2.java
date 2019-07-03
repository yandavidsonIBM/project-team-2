package com.ibm.newhire.menums.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import com.ibm.newhire.menums.model.Menu;
import com.ibm.newhire.menums.model.MenuItem;
import com.ibm.newhire.menums.repo.MenuRepo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class MenuServiceImplTest2 {
	
	@Test
	public void testGetAllMenus_manyFound() {
		//Given
		String name = "menu223";
		String id = "123";
		List<MenuItem> items = Arrays.asList();
		Menu menu = new Menu(id, name, items);
		List<Menu> menuList = Arrays.asList(menu, menu);
		MenuRepo menuRepository = Mockito.mock(MenuRepo.class);
		when(menuRepository.findAll()).thenReturn(menuList);
		
		MenuServiceImpl menuServiceImpl = new MenuServiceImpl(menuRepository);
		
		//When
		List<Menu> menus = menuServiceImpl.getAllMenus();
	
		
		//Then
		assertNotNull("Menu Item name should not be null", menus);
		assertTrue("Menu1 Item should equal menu1", menus.equals(menuList));
		
		verify(menuRepository).findAll();
	}
	
	@Test
	public void testGetAllMenus_nonFound() {
		//Given
		List<Menu> menuList = Arrays.asList();
		MenuRepo menuRepository = Mockito.mock(MenuRepo.class);
		when(menuRepository.findAll()).thenReturn(menuList);
		
		MenuServiceImpl menuServiceImpl = new MenuServiceImpl(menuRepository);
		
		//When
		List<Menu> menus = menuServiceImpl.getAllMenus();
	
		
		//Then
		assertNotNull("Menu Item name should not be null", menus);
		assertTrue("Menu1 Item should equal menu1", menus.equals(menuList));
		
		verify(menuRepository).findAll();
	}
	
	@Test
	public void addMenu() {
		//Given
		String name = "menu223";
		String id = "123";
		List<MenuItem> items = Arrays.asList();
		Menu menu = new Menu(id, name, items);
		MenuRepo menuRepository = Mockito.mock(MenuRepo.class);
		when(menuRepository.save(menu)).thenReturn(menu);
		
		MenuServiceImpl menuServiceImpl = new MenuServiceImpl(menuRepository);
		
		//When
		Menu addedMenu = menuServiceImpl.addMenu(menu);
	
		
		//Then
		assertNotNull("Menu Item name should not be null", addedMenu);
		assertTrue("Menu1 Item should equal menu1", addedMenu.equals(menu));
		
		verify(menuRepository).save(menu);
	}
}
