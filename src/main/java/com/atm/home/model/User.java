package com.atm.home.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.atm.home.enums.AccountStatus;
import com.atm.home.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Auditable<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private Integer accountNumber;
	
	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private AccountType accountTypye;
	

	@Column
	@Enumerated(EnumType.STRING)
	@NotNull
	private AccountStatus accountStatus;
	
	//One to Many 
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_offer",
    joinColumns = {@JoinColumn(name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "offer_id")})
	private Set<Offer> offers = new HashSet<Offer>();
	
	
	//Many to Many 
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "user_beneficiary",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "beneficiary_id"))
	private Set<Beneficiary> beneficiary;
	
	//one to one Mapping 
	@Embedded
	@AttributeOverrides({
	  @AttributeOverride( name = "city", column = @Column(name = "user_city")),
	  @AttributeOverride( name = "country", column = @Column(name = "user_country")),
	  @AttributeOverride( name = "line1", column = @Column(name = "user_address")),
	  @AttributeOverride( name = "state", column = @Column(name = "user_state"))
	})
	private Address address ;
	
}
