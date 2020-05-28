package com.atm.home.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary extends Auditable<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
	
	
	@Column
	private String beneficiaryName;
	
	@Column
	private Integer accountNumber;
	
	@Column
	private String bankName;
	
	@Column
	private String ifscCode;
	
	@ManyToMany(mappedBy = "beneficiary",fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<>();
	
	

}
