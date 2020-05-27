package com.atm.home.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Beneficiary extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy = SEQUENCE, generator = "atm_seq")
    @SequenceGenerator(name = "atm_seq", sequenceName = "atm_seq", allocationSize = 1)
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
	
	@ManyToMany(mappedBy = "beneficiary")
	private Set<User> users = new HashSet<>();
	
	

}
