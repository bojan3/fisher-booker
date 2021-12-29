package com.example.fisherbooker.model.DTO;

import java.util.Set;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageOwner;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOwner;

public class ShipOwnerDTO {

	
	public Account account;
	public Set<Ship> ships;

	
	public ShipOwnerDTO(){}
	
	public ShipOwnerDTO(Account account,Set<Ship> ships){
		this.account=account;
		this.ships=ships;
	}
	
	public static ShipOwnerDTO createShipOwnerDTO(ShipOwner shipowner) {
		return new ShipOwnerDTO(shipowner.getAccount(),shipowner.getShips());
	}

	
	
	
	
	
	
}
