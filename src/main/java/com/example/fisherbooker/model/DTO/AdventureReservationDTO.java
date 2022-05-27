package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.Adventure;
import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.Client;

public class AdventureReservationDTO {
	
	private Long id;

	private Address address;	
	private int capacity;
	private int price;
	private float cancelRate;
	
	private Adventure adventure_id;
	private Client client_id;
	
	//private Adventure a;
	
	public AdventureReservationDTO() {}
	
	
	public AdventureReservationDTO(Long id, String name, String description,int price,float cancelrate,int capacity,Long instructor_id,Long client_id, Address address) {
		super();
		this.id = id;
		this.price=price;
		this.cancelRate=cancelrate;
		this.capacity = capacity;
		
		//this.adventure_id = instructor_id;
		//this.client_id = client_id; 
	
		
		this.address=address;
}
	
	
	
	public  AdventureReservationDTO(AdventureReservation a) {
	this.id=a.getId();
	//this.name=a.getName();
	//this.address=a.getAddress();
	//this.description=a.getDescription();
	this.price=a.getPrice();
	this.capacity=a.getCapacity();
	this.setCancelRate(a.getCancelRate());
    //this.instructor_id=a.getFishingInstructor().getId();
	this.adventure_id = a.adventure;
	this.client_id = a.client;
    
	}

	
	public static AdventureReservationDTO createAdventureReservationDTO(AdventureReservation a) {
		return new AdventureReservationDTO(a);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}





//	public Long getAdventure_id() {
//		return adventure_id;
//	}


//	public void setAdventure_id(Long adventure_id) {
//		this.adventure_id = adventure_id;
//	}


//	public Long getClient_id() {
//		return client_id;
//	}


//	public void setClient_id(Long client_id) {
//		this.client_id = client_id;
//	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public float getCancelRate() {
		return cancelRate;
	}


	public void setCancelRate(float cancelRate) {
		this.cancelRate = cancelRate;
	}
	

}
