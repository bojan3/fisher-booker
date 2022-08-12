package com.example.fisherbooker.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShipSuperDeal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	private int discountedPrice;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private int capacity;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ship_id", nullable = false)
	public Ship ship;

	@ManyToMany(fetch = FetchType.EAGER)
	Set<ShipOption> options = new HashSet<ShipOption>();

	public ShipSuperDeal() {
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

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public void addOption(ShipOption newShipOption) {
		if (newShipOption == null)
			return;
		if (this.options == null)
			this.options = new java.util.HashSet<ShipOption>();
		if (!this.options.contains(newShipOption))
			this.options.add(newShipOption);
	}

	public Set<ShipOption> getOptions() {
		return options;
	}

	public void setOptions(Set<ShipOption> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "ShipSuperDeal [id=" + id + ", startDate=" + startDate + ", discountedPrice=" + discountedPrice
				+ ", endDate=" + endDate + ", capacity=" + capacity + "]";
	}

}