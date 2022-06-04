package com.example.fisherbooker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FishingEquipment {
	@Id
	private String name;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ship_id")
	private Ship ship;

	public FishingEquipment() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	@Override
	public String toString() {
		return "FishingEquipment [name=" + name + ", ship=" + ship + "]";
	}

}