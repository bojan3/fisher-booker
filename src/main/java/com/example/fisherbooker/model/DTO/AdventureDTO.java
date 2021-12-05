package com.example.fisherbooker.model.DTO;

import javax.persistence.Column;

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.Adventure;

public class AdventureDTO {
	

	private Long id;
	private String name;
	private String description;
	private Address address;
	private int capacity;
	private int price;
	private float cancelRate;
	private Long instructor_id;
	
	public AdventureDTO() {}
	
	
	public AdventureDTO(Long id, String name, String description,int price,float cancelrate,int capacity,Long instructor_id,Address address) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price=price;
		this.cancelRate=cancelrate;
		this.capacity=capacity;
		this.instructor_id=instructor_id;
		this.address=address;
}
	
	
	
	public  AdventureDTO(Adventure a) {
	this.id=a.getId();
	this.name=a.getName();
	this.address=a.getAddress();
	this.description=a.getDescription();
	this.price=a.getPrice();
	this.capacity=a.getCapacity();
	this.cancelRate=a.getCancelRate();
    this.instructor_id=a.getFishingInstructor().getId();
	
    
	}

	
	public static AdventureDTO createAdventureDTO(Adventure a) {
		
		return new AdventureDTO(a.getId(), a.getName(), a.getDescription(),a.getPrice(),a.getCancelRate(),a.getCapacity(),a.getFishingInstructor().getId(),a.getAddress());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


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
