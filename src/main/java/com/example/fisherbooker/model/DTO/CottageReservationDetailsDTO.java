package com.example.fisherbooker.model.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CottageReservationDetailsDTO {
	private Long id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private int price;
	private int capacity;
	private String cottageName;
	private String cottageOptions;
	private String userInfo;

	public CottageReservationDetailsDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCottageName() {
		return cottageName;
	}

	public void setCottageName(String cottageName) {
		this.cottageName = cottageName;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getCottageOptions() {
		return cottageOptions;
	}

	public void setCottageOptions(String cottageOptions) {
		this.cottageOptions = cottageOptions;
	}

}
