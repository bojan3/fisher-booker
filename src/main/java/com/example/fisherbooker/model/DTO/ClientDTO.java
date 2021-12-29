package com.example.fisherbooker.model.DTO;

import java.util.Set;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOwner;

public class ClientDTO {

	public Account account;
	
	public ClientDTO(){}
	
	public ClientDTO(Account account){
		this.account=account;
	}
	
	@Override
	public String toString() {
		return "ClientDTO [account=" + account + "]";
	}

	public static ClientDTO createClientDTO(Client client) {
		return new ClientDTO(client.getAccount());
	}

	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
	
	
	
	
	
}
