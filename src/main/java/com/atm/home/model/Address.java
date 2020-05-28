package com.atm.home.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Address {
	
	String city ;
	
	String country;
	
	String line1;
	
	String state;
	

}
