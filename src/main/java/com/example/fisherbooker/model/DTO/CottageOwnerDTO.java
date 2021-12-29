package com.example.fisherbooker.model.DTO;

import java.util.Set;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOwner;

public class CottageOwnerDTO {

	public Account account;
	public Set<Cottage> cottages;

	
	public CottageOwnerDTO(){}
	
	public CottageOwnerDTO(Account account,Set<Cottage> cottages){
		this.account=account;
		this.cottages=cottages;
	}
	
	public static CottageOwnerDTO createCottageOwnerDTO(CottageOwner cottageowner) {
		return new CottageOwnerDTO(cottageowner.getAccount(),cottageowner.getCottages());
	}

}
