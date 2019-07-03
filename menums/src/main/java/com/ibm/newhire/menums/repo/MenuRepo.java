package com.ibm.newhire.menums.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.newhire.menums.model.Menu;

public interface MenuRepo extends MongoRepository<Menu, Long>{
	public Menu findById(String id);
	public List<Menu> findAll();
}
