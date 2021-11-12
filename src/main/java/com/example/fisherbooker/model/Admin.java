package com.example.fisherbooker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Admin {

	@Id
	@OneToOne
	private Account account;
	
}