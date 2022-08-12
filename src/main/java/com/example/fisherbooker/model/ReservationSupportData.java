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
	private Date reservationdate;
	@Column
	private float systemIncome;
	
	@Column
	private String dtype;
	
	public ReservationSupportData() {
		super();
		this.reservationdate= new Date();
	//	GlobalNumberService gs  = new GlobalNumberService();
	//	this.systemIncome=gs.GetByID((long) 1).getValuex();
	}

	public ReservationSupportData(Long id, Date reservationdate, float systemIncome) {
		super();
		this.id = id;
		this.reservationdate = reservationdate;
		this.systemIncome = systemIncome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getReservationdate() {
		return reservationdate;
	}

	public void setReservationdate(Date reservationdate) {
		this.reservationdate = reservationdate;
	}

	public float getSystemIncome() {
		return systemIncome;
	}

	public void setSystemIncome(float systemIncome) {
		this.systemIncome = systemIncome;
	}


	@Override
	public String toString() {
		return "ReservationSupportData [id=" + id + ", reservationdate=" + reservationdate + ", systemIncome="
				+ systemIncome + "  ]";
	}
	
	
	
	
}
