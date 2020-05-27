package com.atm.home.model;

import static javax.persistence.GenerationType.SEQUENCE;

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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.atm.home.enums.AccountStatus;
import com.atm.home.enums.AccountType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@Entity
@NoArgsConstructor
public class User extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy = SEQUENCE, generator = "atm_seq")
    @SequenceGenerator(name = "atm_seq", sequenceName = "atm_seq", allocationSize = 1)
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
	
	//One to Many 
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private Set<Offer> offers = new HashSet<Offer>();
	
	@Column
	@Enumerated(EnumType.STRING)
	@NotNull
	private AccountStatus accountStatus;
	
	//Many to Many 
	@ManyToMany(cascade = CascadeType.ALL)
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
