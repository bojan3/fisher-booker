package com.example.fisherbooker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@OneToMany(mappedBy = "cottageOwner", fetch = FetchType.EAGER)
	public Set<Cottage> cottages = new HashSet<Cottage>();

	public CottageOwner() {
		super();
	}

	public CottageOwner(Set<Cottage> cottages, Account account) {
		super();
		this.cottages = cottages;
		this.account = account;
	}

	public Set<Cottage> getCottages() {
		return cottages;
	}

	public void setCottages(Set<Cottage> cottages) {
		this.cottages = cottages;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "CottageOwner [account=" + account + ", cottage=" + cottages + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}