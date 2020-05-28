package com.atm.home.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.atm.home.enums.OfferStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offer extends Auditable<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
	
	
	@Column
	private String offerName;
	
	@Column
	@Enumerated(EnumType.STRING)
	private OfferStatus offerStatus;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id",updatable = true, insertable = true)
	private User user;
	
	
	
}
