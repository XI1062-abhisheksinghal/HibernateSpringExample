package com.atm.home.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atm.home.model.Beneficiary;
import com.atm.home.model.User;
import com.atm.home.repository.UserRepository;
import com.atm.home.requestDTO.UserRequestDTO;
import com.atm.home.response.BeneficiaryResponse;
import com.atm.home.response.BeneficiaryResponseList;

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
     
	
	@RequestMapping("/getAllbeneficiaries/{userName}")
	@GetMapping
	public ResponseEntity<List<BeneficiaryResponse>> getAllBeneficiary(@PathVariable String userName){
		
		
		List<BeneficiaryResponse> ls = new ArrayList<BeneficiaryResponse>();
		User user =userRepo.findByName(userName);
		 System.out.println("======"+user.getOffers());
		Set<Beneficiary> set =user.getBeneficiary();
		for(Beneficiary b :set) {
			BeneficiaryResponse br = new BeneficiaryResponse();
			br.setAccountNumber(b.getAccountNumber());
			br.setBankName(b.getBankName());
			br.setBeneficiaryName(b.getBeneficiaryName());
			br.setIfscCode(b.getIfscCode());
			
			ls.add(br);
		}
		return ResponseEntity.ok(ls);
	}
	
	//create API to post user 
	//Create API to fetch all the benficiaries of a user 
	//Create API to fetch all the offers of a user 
	
}
