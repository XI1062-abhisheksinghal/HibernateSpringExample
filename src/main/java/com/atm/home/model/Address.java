package com.atm.home.model;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Address {
	
	String city ;
	
	String country;
	
	String line1;
	
	String state;
	

}
