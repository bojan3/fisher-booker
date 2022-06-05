package com.example.fisherbooker.model.DTO;

import java.util.Set;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOwner;

public class CottageOwnerDTO {

	public Long id;
	public Account account;
	public Set<Cottage> cottages;

	
	public CottageOwnerDTO(){}
	
	public CottageOwnerDTO(Account account,Set<Cottage> cottages, Long id){
		this.account=account;
		this.cottages=cottages;
		this.id = id;
	}
	
	public static CottageOwnerDTO createCottageOwnerDTO(CottageOwner cottageowner) {
		return new CottageOwnerDTO(cottageowner.getAccount(),cottageowner.getCottages(), cottageowner.getId());
	}
	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Cottage> getCottages() {
		return cottages;
	}
	
	public void setCottages(Set<Cottage> cottages) {
		this.cottages=cottages;
	}

	public void setID(Long id2) {
		this.id=id2;
	}
	public Long getID() {
		return this.id;
	}
	
	

}
