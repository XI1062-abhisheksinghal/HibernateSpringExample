package com.atm.home.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.*;

@Entity
@Table(name = "Credentials")
public class Credentials  extends Auditable<String> {

	@Id
    @GeneratedValue(strategy = SEQUENCE, generator = "atm_seq")
    @SequenceGenerator(name = "atm_seq", sequenceName = "atm_seq", allocationSize = 1)
    @Column
	private Integer id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}