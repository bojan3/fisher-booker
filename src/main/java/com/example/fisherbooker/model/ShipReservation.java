package com.example.fisherbooker.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShipReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date startDate;
	private Date endDate;
	private int price;
	private int capacity;

	@ManyToMany
	public Set<ShipOption> shipOption;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ship_id", nullable = false)
	public Ship ship;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	public Client client;

	public ShipReservation() {
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

	public Set<ShipOption> getShipOption() {
		return shipOption;
	}

	public void setShipOption(Set<ShipOption> shipOption) {
		this.shipOption = shipOption;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "ShipReservation [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price
				+ ", capacity=" + capacity + ", shipOption=" + shipOption + ", ship=" + ship + ", client=" + client
				+ "]";
	}

}