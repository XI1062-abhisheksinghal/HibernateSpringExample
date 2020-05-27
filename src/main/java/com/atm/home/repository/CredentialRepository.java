package com.atm.home.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atm.home.model.Credentials;
import com.atm.home.requestDTO.CredentialDTO;

@Repository
public interface CredentialRepository extends CrudRepository<Credentials,Integer >{
        
	Credentials findByUsername(String username);
}
