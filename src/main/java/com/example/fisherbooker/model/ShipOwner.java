package com.example.fisherbooker.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ShipOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	public Account account;

	@OneToMany(mappedBy = "shipOwner", fetch = FetchType.EAGER)
	public Set<Ship> ships;

	public ShipOwner() {
		super();
	}

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

	@Override
	public String toString() {
		return "ShipOwner [id=" + id + ", account=" + account + ", ships=" + ships + "]";
	}

	public void removeAllShips() {
		
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

}