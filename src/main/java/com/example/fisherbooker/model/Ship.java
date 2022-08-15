package com.example.fisherbooker.model;

import java.util.HashSet;
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ship_owner_id")
	private ShipOwner shipOwner;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<Rule> rules = new HashSet<Rule>();

	@OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<NavigationEquipment> navigationEquipments = new HashSet<NavigationEquipment>();

	@OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<FishingEquipment> fishingEquipments = new HashSet<FishingEquipment>();

	@OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ShipPicture> shipPictures;

	@OneToMany(mappedBy = "ship", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ShipSuperDeal> shipSuperDeals;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private AvailabilityPeriod availabilityPeriod;

	@OneToMany(mappedBy = "ship", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<ShipOption> shipOptions = new HashSet<ShipOption>();

	@JsonIgnore
	@OneToMany(mappedBy = "ship", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<ShipReservation> shipReservations;

	@JsonIgnore
	@ManyToMany(mappedBy = "shipSubscriptions", fetch = FetchType.EAGER)
	private Set<Client> client;

	@JsonIgnore
	@OneToMany(mappedBy = "ship", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<ShipReview> shipReviews = new HashSet<ShipReview>();

	public Ship() {
		super();
	}
	
	public Ship(Long id) {
		super();
		this.id = id;
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
		for (ShipOption so : shipOptions) {
			so.setShip(this);
			this.shipOptions.add(ShipOption.toModel(so));
		}
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
		for (Rule r : rules) {
			this.rules.add(Rule.toModel(r));
		}
	}

	public Set<NavigationEquipment> getNavigationEquipments() {
		return navigationEquipments;
	}

	public void setNavigationEquipments(Set<NavigationEquipment> navigationEquipments) {
		for (NavigationEquipment ne : navigationEquipments) {
			ne.setShip(this);
			this.navigationEquipments.add(NavigationEquipment.toModel(ne));
		}
	}

	public Set<FishingEquipment> getFishingEquipments() {
		return fishingEquipments;
	}

	public void setFishingEquipments(Set<FishingEquipment> fishingEquipments) {
		for (FishingEquipment fe : fishingEquipments) {
			fe.setShip(this);
			this.fishingEquipments.add(FishingEquipment.toModel(fe));
		}
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

	@Override
	public String toString() {
		return "Ship [id=" + id + ", name=" + name + ", type=" + type + ", length=" + length + ", description="
				+ description + ", averageMark=" + averageMark + ", rentPrice=" + rentPrice + ", engineNumber="
				+ engineNumber + ", enginePower=" + enginePower + ", maxSpeed=" + maxSpeed + ", capacity=" + capacity
				+ ", cancelRate=" + cancelRate + ", address=" + address + ", rules=" + rules + ", navigationEquipments="
				+ navigationEquipments + ", fishingEquipments=" + fishingEquipments + ", shipPictures=" + shipPictures
				+ ", shipSuperDeals=" + shipSuperDeals + ", availabilityPeriod=" + availabilityPeriod + ", shipOptions="
				+ shipOptions + "]";
	}

}