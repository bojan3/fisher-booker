package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.Address;
import com.example.fisherbooker.model.Cottage;

import net.bytebuddy.asm.Advice.This;
import net.bytebuddy.description.type.RecordComponentDescription.ForLoadedRecordComponent;
import net.bytebuddy.description.type.TypeList.Generic.OfLoadedInterfaceTypes;

public class CottageDTO {
	private Long id;
	private String name;
	private String description;
	private int pricePerDay;
	public Address address;
	public float averageMark;
	public CottageDTO(Long id, String name, String description, Address address,int price, float averageMark) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.pricePerDay=price;
		this.address = address;
		this.averageMark = averageMark;
	}
	
	public CottageDTO(Cottage cottage) {
		this.id = cottage.getId();
		this.name = cottage.getName();
		this.description = cottage.getDescription();
		this.pricePerDay = cottage.getPricePerDay();
		this.address = cottage.getAddress();
		this.averageMark = cottage.getAverageMark();
	}
	
	public static CottageDTO createCottageDTO(Cottage c) {
		return new CottageDTO(c.getId(), c.getName(), c.getDescription(), c.getAddress(),c.getPricePerDay(), c.getAverageMark());
	}

	public CottageDTO() {
		super();
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public float getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
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
