package com.example.fisherbooker.model;

import java.util.HashSet;
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

	private String imagePath;

	@OneToOne(cascade = CascadeType.ALL)
	public Address address;

	@OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Room> rooms = new HashSet<Room>();

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<Rule> rules = new HashSet<Rule>();

	@OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<CottageSuperDeal> cottageSuperDeals = new HashSet<CottageSuperDeal>();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public AvailabilityPeriod availabilityPeriod = new AvailabilityPeriod();

	@OneToMany(mappedBy = "cottage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<CottagePicture> cottagePictures = new HashSet<CottagePicture>();

	@JsonIgnore
	@OneToMany(mappedBy = "cottage", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = true)
	public Set<CottageReservation> cottageReservations = new HashSet<CottageReservation>();

	@OneToMany(mappedBy = "cottage", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<CottageOption> cottageOptions = new HashSet<CottageOption>();

	@JsonIgnore
	@OneToMany(mappedBy = "cottage", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<CottageReview> cottageReviews = new HashSet<CottageReview>();
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cottage_owner_id")
	private CottageOwner cottageOwner;

	@JsonIgnore
	@ManyToMany(mappedBy = "cottageSubscriptions")
	private Set<Client> client;

	public Cottage() {
	}

	public Cottage(Long id) {
		this.id = id;
	}

	public void free() {
		this.setCottageOptions(null);
		this.setCottageReservations(null);
		this.setCottageSuperDeals(null);
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
		for (Rule r : rules) {
			this.rules.add(Rule.toModel(r));
		}
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
		for (CottageOption co : cottageOptions) {
			co.setCottage(this);
			this.cottageOptions.add(CottageOption.toModel(co));
		}
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}