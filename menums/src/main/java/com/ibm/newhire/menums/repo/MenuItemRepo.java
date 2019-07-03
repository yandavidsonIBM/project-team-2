package com.ibm.newhire.menums.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.newhire.menums.model.MenuItem;

public interface MenuItemRepo extends MongoRepository<MenuItem, Long> {
	public MenuItem findByName(String name);
}


