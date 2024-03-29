package com.example.fisherbooker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FishingEquipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ship_id")
	private Ship ship;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "adventure_id")
	private Adventure adventure;

	public FishingEquipment() {
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

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public Adventure getAdventure() {
		return adventure;
	}

	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}

	public static FishingEquipment toModel(FishingEquipment equipment) {
		FishingEquipment newEquipment = new FishingEquipment();
		if(equipment.getId() != 0) {
			newEquipment.setId(equipment.getId());
		}
		newEquipment.setName(equipment.getName());
		newEquipment.setShip(equipment.getShip());
		newEquipment.setAdventure(equipment.getAdventure());
		return newEquipment;
	}
	
	@Override
	public String toString() {
		return "FishingEquipment [name=" + name + "]";
	}

}