package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.Cottage;

public class CottageDTO {
	private Long id;
	private String name;
	private String description;
	//public Address address;
	
	public CottageDTO(Long id, String name, String description, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//this.address = address;
	}
	
	public static CottageDTO createCottageDTO(Cottage c) {
		return new CottageDTO(c.getId(), c.getName(), c.getDescription(), c.getAddress());
	}

	public CottageDTO() {
		super();
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

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

//	@Override
//	public String toString() {
//		return "CottageDTO [id=" + id + ", name=" + name + ", description=" + description + ", address=" + address
//				+ "]";
//	}
}
