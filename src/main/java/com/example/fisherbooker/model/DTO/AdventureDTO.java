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
	
	public AdventureDTO(Long id, String name, String description, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//this.address = address;
	}
	
	
	public  AdventureDTO(Adventure a) {
	this.id=a.getId();
	this.name=a.getName();
	this.address=a.getAddress();
	this.description=a.getDescription();
			
	}

	
	public AdventureDTO createAdventureDTO(Adventure a) {
		AdventureDTO adto= new AdventureDTO(a);
		return adto;
	}
	
	
	
	

}
