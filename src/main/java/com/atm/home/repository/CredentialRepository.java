package com.atm.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atm.home.model.Credentials;

@Repository
public interface CredentialRepository extends CrudRepository<Credentials,Integer >{
        
	Credentials findByUsername(String username);
	
	 @Query("SELECT c.username FROM Credentials c where c.username = :name") 
    List<String> selectAllUserNames(String name);
}
