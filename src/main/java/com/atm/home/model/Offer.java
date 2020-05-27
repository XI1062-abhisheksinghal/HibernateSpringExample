package com.atm.home.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.atm.home.enums.OfferStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Offer extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy = SEQUENCE, generator = "atm_seq")
    @SequenceGenerator(name = "atm_seq", sequenceName = "atm_seq", allocationSize = 1)
    @Column
    private Integer id;
	
	
	@Column
	private String offerName;
	
	@Column
	@Enumerated(EnumType.STRING)
	private OfferStatus offerStatus;
	
	@ManyToOne
	private User user;
	
	
}
