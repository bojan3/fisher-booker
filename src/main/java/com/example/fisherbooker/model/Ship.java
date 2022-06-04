package com.example.fisherbooker.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20)
	private String name;
	@Enumerated(EnumType.STRING)
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

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ship_owner_id")
	private ShipOwner shipOwner;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<Rule> rules;

	@OneToMany(mappedBy = "ship", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<NavigationEquipment> navigationEquipments;

	@OneToMany(mappedBy = "ship", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<FishingEquipment> fishingEquipments;

	@OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ShipPicture> shipPictures;

	@OneToMany(mappedBy = "ship", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ShipSuperDeal> shipSuperDeals;

	@OneToOne(cascade = CascadeType.ALL)
	private AvailabilityPeriod availabilityPeriod;

	@OneToMany(mappedBy = "ship", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<ShipOption> shipOptions;

	@JsonIgnore
	@OneToMany(mappedBy = "ship", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<ShipReservation> shipReservations;

	@JsonIgnore
	@ManyToMany(mappedBy = "shipSubscriptions")
	private Set<Client> client;

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

	public ShipOwner getShipOwner() {
		return shipOwner;
	}

	public void setShipOwner(ShipOwner shipOwner) {
		this.shipOwner = shipOwner;
	}

	public AvailabilityPeriod getAvailabilityPeriod() {
		return availabilityPeriod;
	}

	public void setAvailabilityPeriod(AvailabilityPeriod availabilityPeriod) {
		this.availabilityPeriod = availabilityPeriod;
	}

	public Set<Rule> getRules() {
		return rules;
	}

	public void setRules(Set<Rule> rules) {
		this.rules = rules;
	}

	public Set<NavigationEquipment> getNavigationEquipments() {
		return navigationEquipments;
	}

	public void setNavigationEquipments(Set<NavigationEquipment> navigationEquipments) {
		this.navigationEquipments = navigationEquipments;
	}

	public Set<FishingEquipment> getFishingEquipments() {
		return fishingEquipments;
	}

	public void setFishingEquipments(Set<FishingEquipment> fishingEquipments) {
		this.fishingEquipments = fishingEquipments;
	}

	public Set<ShipPicture> getShipPictures() {
		return shipPictures;
	}

	public void setShipPictures(Set<ShipPicture> shipPictures) {
		this.shipPictures = shipPictures;
	}

	public Set<ShipSuperDeal> getShipSuperDeals() {
		return shipSuperDeals;
	}

	public void setShipSuperDeals(Set<ShipSuperDeal> shipSuperDeals) {
		this.shipSuperDeals = shipSuperDeals;
	}

	public Set<ShipReservation> getShipReservations() {
		return shipReservations;
	}

	public void setShipReservations(Set<ShipReservation> shipReservations) {
		this.shipReservations = shipReservations;
	}

	public Set<Client> getClient() {
		return client;
	}

	public void setClient(Set<Client> client) {
		this.client = client;
	}

}