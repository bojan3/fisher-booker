package com.example.fisherbooker.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ShipOwner {

	@Id
	@OneToOne
	public Account account;
	
	@OneToMany
	public Set<Ship> ships;
	
	public ShipOwner(Account account, Set<Ship> ships) {
		super();
		this.account = account;
		this.ships = ships;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Ship> getShips() {
		return ships;
	}

	public void setShips(Set<Ship> ships) {
		this.ships = ships;
	}
	
}