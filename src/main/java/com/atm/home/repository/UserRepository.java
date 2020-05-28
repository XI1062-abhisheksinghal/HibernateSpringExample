package com.atm.home.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atm.home.model.User;
import java.lang.String;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>  {
	
	User findByName(String name);
	
	

}
