package com.example.fisherbooker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.example.fisherbooker.repository.GlobalNumberRepository;
import com.example.fisherbooker.service.GlobalNumberService;

@MappedSuperclass
public class ReservationSupportData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String reservationdate;
	@Column
	private float systemIncome;
	
	@Column
	private int price;
	
	@Column
	private String dtype;
	
	public ReservationSupportData() {
		super();
	//	this.reservationdate= new Date();
	//	GlobalNumberService gs  = new GlobalNumberService();
	//	this.systemIncome=gs.GetByID((long) 1).getValuex();
	}

	public ReservationSupportData(Long id, String reservationdate, float systemIncome, int price) {
		super();
		this.id = id;
		this.reservationdate = reservationdate;
		this.systemIncome = systemIncome;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReservationdate() {
		return reservationdate;
	}

	public void setReservationdate(String reservationdate) {
		this.reservationdate = reservationdate;
	}

	public float getSystemIncome() {
		return systemIncome;
	}

	public void setSystemIncome(float systemIncome) {
		this.systemIncome = systemIncome;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	

	@Override
	public String toString() {
		return "ReservationSupportData [id=" + id + ", reservationdate=" + reservationdate + ", systemIncome="
				+ systemIncome + ""+ "price:"+ price + "]";
	}
	
	
	
	
}
