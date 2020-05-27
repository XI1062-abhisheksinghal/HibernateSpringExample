package com.atm.home.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atm.home.model.User;
import com.atm.home.repository.UserRepository;
import com.atm.home.requestDTO.UserRequestDTO;

@RestController
@RequestMapping("/atm")
public class UserController {
	
	private ModelMapper modelMapper;
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	public UserController(){
		modelMapper = new ModelMapper();
	}
	
	
	@RequestMapping("/user")
	@GetMapping
	public void userData() {
		System.out.println("hello from ATM");
	}
	
	@RequestMapping("/userdata")
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody UserRequestDTO userDto) {
		
		User user = modelMapper.map(userDto, User.class);
		 return  ResponseEntity.ok(userRepo.save(user));
	}
     
	
	//create API to post user 
	//Create API to fetch all the benficiaries of a user 
	//Create API to fetch all the offers of a user 
	
}
