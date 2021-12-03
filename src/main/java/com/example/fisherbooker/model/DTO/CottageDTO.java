package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.Cottage;

public class CottageDTO {
	private Long id;
	private String name;
	private String description;
	private int pricePerDay;
	public Address address;
	
	public CottageDTO(Long id, String name, String description, Address address,int price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.pricePerDay=price;
		this.address = address;
	}
	
	public static CottageDTO createCottageDTO(Cottage c) {
		return new CottageDTO(c.getId(), c.getName(), c.getDescription(), c.getAddress(),c.getPricePerDay());
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

	public int getPrice_per_day() {
		return pricePerDay;
	}

	public void setPrice_per_day(int price_per_day) {
		this.pricePerDay = price_per_day;
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
