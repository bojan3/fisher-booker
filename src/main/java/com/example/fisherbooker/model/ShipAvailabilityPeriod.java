package com.example.fisherbooker.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShipAvailabilityPeriod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "ship_id")
	private Ship ship;

	public ShipAvailabilityPeriod() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public static ShipAvailabilityPeriod toModel(ShipAvailabilityPeriod newAp) {
		ShipAvailabilityPeriod ap = new ShipAvailabilityPeriod();
		newAp.setStartDate(ap.getStartDate());
		newAp.setEndDate(ap.getEndDate());
		newAp.setShip(ap.getShip());
		return ap;
	}

	@Override
	public String toString() {
		return "ShipAvailabilityPeriod [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", ship="
				+ ship + "]";
	}

}
