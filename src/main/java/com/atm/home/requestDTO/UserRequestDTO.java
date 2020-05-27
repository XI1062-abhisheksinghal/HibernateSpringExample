package com.atm.home.requestDTO;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.atm.home.enums.AccountStatus;
import com.atm.home.enums.AccountType;
import com.atm.home.model.Address;
import com.atm.home.model.Beneficiary;
import com.atm.home.model.Offer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDTO {
	
	private String name;
	
	private Integer accountNumber;
	
	private AccountType accountTypye;
	
	private Set<Offer> offers;
	
	private AccountStatus accountStatus;
	
	private Set<Beneficiary> beneficiary;
	
	private Address address ;
	
	

}
