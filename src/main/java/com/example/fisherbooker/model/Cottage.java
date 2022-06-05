package com.example.fisherbooker.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Cottage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30)
	private String name;
	@Column(length = 300)
	private String description;
	@Column
	private int pricePerDay;
	private float averageMark;

	@OneToOne(cascade = CascadeType.ALL)
	public Address address;

	@JsonIgnore
	@OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Room> rooms;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = true)
	public Set<Rule> rules;

	@OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<CottageSuperDeal> cottageSuperDeals;

	@OneToOne(cascade = CascadeType.ALL)
	public AvailabilityPeriod availabilityPeriod;

	@JsonIgnore
	@OneToMany(mappedBy = "cottage", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	public Set<CottagePicture> cottagePictures;

	
	@JsonIgnore
	@OneToMany(mappedBy = "cottage", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<CottageReservation> cottageReservations;

	@OneToMany(mappedBy = "cottage", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<CottageOption> cottageOptions;

	@JsonIgnore
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cottage_owner_id")
	private CottageOwner cottageOwner;

	@JsonIgnore
	@ManyToMany(mappedBy = "cottageSubscriptions")
	private Set<Client> client;

	
	public void free() {
		this.setAvailabilityPeriod(null);
		this.setCottageOptions(null);
		this.setCottageReservation(null); 
		this.setCottageFastReservation(null);
	}
	
	public Cottage() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public float getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Set<Rule> getRules() {
		return rules;
	}

	public void setRules(Set<Rule> rules) {
		this.rules = rules;
	}

	public Set<CottageSuperDeal> getCottageSuperDeals() {
		return cottageSuperDeals;
	}

	public void setCottageSuperDeals(Set<CottageSuperDeal> cottageSuperDeals) {
		this.cottageSuperDeals = cottageSuperDeals;
	}

	public AvailabilityPeriod getAvailabilityPeriod() {
		return availabilityPeriod;
	}

	public void setAvailabilityPeriod(AvailabilityPeriod availabilityPeriod) {
		this.availabilityPeriod = availabilityPeriod;
	}

	public Set<CottagePicture> getCottagePictures() {
		return cottagePictures;
	}

	public void setCottagePictures(Set<CottagePicture> cottagePictures) {
		this.cottagePictures = cottagePictures;
	}

	public Set<CottageReservation> getCottageReservations() {
		return cottageReservations;
	}

	public void setCottageReservations(Set<CottageReservation> cottageReservations) {
		this.cottageReservations = cottageReservations;
	}

	public Set<CottageOption> getCottageOptions() {
		return cottageOptions;
	}

	public void setCottageOptions(Set<CottageOption> cottageOptions) {
		this.cottageOptions = cottageOptions;
	}

	public CottageOwner getCottageOwner() {
		return cottageOwner;
	}

	public void setCottageOwner(CottageOwner cottageOwner) {
		this.cottageOwner = cottageOwner;
	}

	public Set<Client> getClient() {
		return client;
	}

	public void setClient(Set<Client> client) {
		this.client = client;
	}

	
	
	
}