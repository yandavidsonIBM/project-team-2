package com.ibm.newhire.menums.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import com.ibm.newhire.menums.model.Menu;
import com.ibm.newhire.menums.model.MenuItem;
import com.ibm.newhire.menums.repo.MenuItemRepo;
import com.ibm.newhire.menums.repo.MenuRepo;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class MenuServiceImplTest {
	
	@Test
	public void testFindMenuItemMenuFound() {
		
		//Given
		
		String id = "123";
		List<Integer> listIn =new ArrayList<Integer>();
		Menu menu = new Menu();
	 	menu.setId(id);
		MenuRepo menuRepository = Mockito.mock(MenuRepo.class);
		when(menuRepository.findById(id)).thenReturn(menu);
		
		MenuServiceImpl menuServiceImpl = new MenuServiceImpl(menuRepository);
		
		//When
		Menu returnedMenu = menuServiceImpl.findMenuById(id);
	
		
		//Then
		assertNotNull("Menu Item name should not be null", returnedMenu);
		assertTrue("Menu1 Item should equal menu1", menu.equals(returnedMenu));
		
		verify(menuRepository).findById(id);
					
		
	}
	
	
	@Test
	public void testFindAllMenu() {
		//Given
		
		
		//When
		
		
		//Then
	}

}
