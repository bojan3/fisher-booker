package com.example.fisherbooker.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20)
	private String name;
	@Enumerated(EnumType.ORDINAL)
	private ShipType type;
	private float length;
	@Column(length = 350)
	private String description;
	@Column(nullable = true)
	private float averageMark;
	private int rentPrice;
	private int engineNumber;
	private int enginePower;
	private float maxSpeed;
	private int capacity;
	private float cancelRate;

	@OneToOne(cascade = CascadeType.ALL)
	public Address address;

	@ManyToOne
	@JoinColumn(name = "ship_owner_id")
	public ShipOwner shipOwner;

	@OneToMany
	public Set<Rule> rule;

	@ManyToMany
	public Set<NavigationEquipment> navigationEquipment;

	@ManyToMany
	public Set<FishingEquipment> fishingEquipment;

	@OneToMany(mappedBy = "ship", cascade = CascadeType.ALL)
	public Set<ShipPicture> shipPicture;

	@OneToMany(mappedBy = "ship")
	public Set<ShipSuperDeal> shipSuperDeal;

	@ManyToMany
	public Set<ShipOption> shipOptions;

	@OneToMany(mappedBy = "ship")
	public Set<ShipReservation> shipReservation;

	public Ship() {
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

	public ShipType getType() {
		return type;
	}

	public void setType(ShipType type) {
		this.type = type;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public int getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(int engineNumber) {
		this.engineNumber = engineNumber;
	}

	public int getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getCancelRate() {
		return cancelRate;
	}

	public void setCancelRate(float cancelRate) {
		this.cancelRate = cancelRate;
	}

	public Set<Rule> getRule() {
		return rule;
	}

	public void setRule(Set<Rule> rule) {
		this.rule = rule;
	}

	public Set<NavigationEquipment> getNavigationEquipment() {
		return navigationEquipment;
	}

	public void setNavigationEquipment(Set<NavigationEquipment> navigationEquipment) {
		this.navigationEquipment = navigationEquipment;
	}

	public Set<FishingEquipment> getFishingEquipment() {
		return fishingEquipment;
	}

	public void setFishingEquipment(Set<FishingEquipment> fishingEquipment) {
		this.fishingEquipment = fishingEquipment;
	}

	public Set<ShipPicture> getShipPicture() {
		return shipPicture;
	}

	public void setShipPicture(Set<ShipPicture> shipPicture) {
		this.shipPicture = shipPicture;
	}

	public Set<ShipSuperDeal> getShipSuperDeal() {
		return shipSuperDeal;
	}

	public void setShipSuperDeal(Set<ShipSuperDeal> shipSuperDeal) {
		this.shipSuperDeal = shipSuperDeal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<ShipOption> getShipOptions() {
		return shipOptions;
	}

	public void setShipOptions(Set<ShipOption> shipOptions) {
		this.shipOptions = shipOptions;
	}

	public Set<ShipReservation> getShipReservation() {
		return shipReservation;
	}

	public void setShipReservation(Set<ShipReservation> shipReservation) {
		this.shipReservation = shipReservation;
	}

	public ShipOwner getShipOwner() {
		return shipOwner;
	}

	public void setShipOwner(ShipOwner shipOwner) {
		this.shipOwner = shipOwner;
	}

}