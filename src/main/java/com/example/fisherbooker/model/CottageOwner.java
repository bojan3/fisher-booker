package com.example.fisherbooker.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CottageOwner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	public Account account;

	@OneToMany
	public Set<Cottage> cottage;
	
	public CottageOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CottageOwner(Set<Cottage> cottage, Account account) {
		super();
		this.cottage = cottage;
		this.account = account;
	}

	public Set<Cottage> getCottage() {
		return cottage;
	}

	public void setCottage(Set<Cottage> cottage) {
		this.cottage = cottage;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "CottageOwner [account=" + account + ", cottage=" + cottage + "]";
	}
	
}