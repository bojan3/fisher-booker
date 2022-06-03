package com.example.fisherbooker.model.DTO;

import java.util.Set;

import com.example.fisherbooker.model.Account;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.Client;
import com.example.fisherbooker.model.Cottage;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.FishingInstructor;
import com.example.fisherbooker.model.Ship;
import com.example.fisherbooker.model.ShipOwner;
import com.example.fisherbooker.model.ShipReservation;

public class ClientDTO {

	private Account account;
	private Set<ShipReservation> shipReservation;
	private Set<CottageReservation> cottageReservation;
	private Set<AdventureReservation> adventureReservation;
	private Set<Cottage> cottageSubscriptions;
	private Set<Ship> shipSubscriptions;
	private Set<FishingInstructor> instructorSubscriptions;
	
	public ClientDTO(){}
	
	public ClientDTO(Client client) {
		this.account = client.account;
		this.shipReservation = client.shipReservation;
		this.cottageReservation = client.cottageReservation;
		this.adventureReservation = client.adventureReservation;
		this.cottageSubscriptions = client.getCottageSubscriptions();
		this.shipSubscriptions = client.getShipSubscriptions();
		this.instructorSubscriptions = client.getInstructorSubscriptions();
	}
	
	
	
	public Set<ShipReservation> getShipReservation() {
		return shipReservation;
	}

	public void setShipReservation(Set<ShipReservation> shipReservation) {
		this.shipReservation = shipReservation;
	}

	public Set<CottageReservation> getCottageReservation() {
		return cottageReservation;
	}

	public void setCottageReservation(Set<CottageReservation> cottageReservation) {
		this.cottageReservation = cottageReservation;
	}

	public Set<AdventureReservation> getAdventureReservation() {
		return adventureReservation;
	}

	public void setAdventureReservation(Set<AdventureReservation> adventureReservation) {
		this.adventureReservation = adventureReservation;
	}

	public Set<Cottage> getCottageSubscriptions() {
		return cottageSubscriptions;
	}

	public void setCottageSubscriptions(Set<Cottage> cottageSubscriptions) {
		this.cottageSubscriptions = cottageSubscriptions;
	}

	public Set<Ship> getShipSubscriptions() {
		return shipSubscriptions;
	}

	public void setShipSubscriptions(Set<Ship> shipSubscriptions) {
		this.shipSubscriptions = shipSubscriptions;
	}

	public Set<FishingInstructor> getInstructorSubscriptions() {
		return instructorSubscriptions;
	}

	public void setInstructorSubscriptions(Set<FishingInstructor> instructorSubscriptions) {
		this.instructorSubscriptions = instructorSubscriptions;
	}

	public ClientDTO(Account account){
		this.account=account;
	}
	
	@Override
	public String toString() {
		return "ClientDTO [account=" + account + ", shipReservation=" + shipReservation + ", cottageReservation="
				+ cottageReservation + ", adventureReservation=" + adventureReservation + ", cottageSubscriptions="
				+ cottageSubscriptions + ", shipSubscriptions=" + shipSubscriptions + ", instructorSubscriptions="
				+ instructorSubscriptions + "]";
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
