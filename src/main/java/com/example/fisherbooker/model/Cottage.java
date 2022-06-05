package com.example.fisherbooker.model;

import java.util.List;
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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.fisherbooker.model.DTO.CottageAddDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@Column
	private float averageMark;

	@OneToOne(cascade = CascadeType.ALL)
	public Address address;

	@JsonIgnore
	@OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Room> rooms;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = true)
	public Set<Rule> rules;

	@OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<CottageSuperDeal> cottageSuperDeal;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	public AvailabilityPeriod availabilityPeriod;

	@JsonIgnore
	@OneToMany(mappedBy = "cottage", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	public Set<CottagePicture> cottagePictures;

	
	@JsonIgnore
	@OneToMany(mappedBy = "cottage", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<CottageReservation> cottageReservation;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<CottageOption> cottageOptions;

	// @JsonIgnore
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cottage_owner_id")
	private CottageOwner cottageOwner;

	
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

	public Set<CottageSuperDeal> getCottageFastReservation() {
		return cottageSuperDeal;
	}

	public void setCottageFastReservation(Set<CottageSuperDeal> cottageFastReservation) {
		this.cottageSuperDeal = cottageFastReservation;
	}

	public AvailabilityPeriod getAvailabilityPeriod() {
		return availabilityPeriod;
	}

	public void setAvailabilityPeriod(AvailabilityPeriod availabilityPeriod) {
		this.availabilityPeriod = availabilityPeriod;
	}

	public Set<CottagePicture> getCottagePicture() {
		return cottagePictures;
	}

	public void setCottagePicture(Set<CottagePicture> cottagePicture) {
		this.cottagePictures = cottagePicture;
	}

	public Set<CottageReservation> getCottageReservation() {
		return cottageReservation;
	}

	public void setCottageReservation(Set<CottageReservation> cottageReservation) {
		this.cottageReservation = cottageReservation;
	}

	public Set<CottageOption> getCottageOptions() {
		return cottageOptions;
	}

	public void setCottageOptions(Set<CottageOption> cottageOptions) {
		this.cottageOptions = cottageOptions;
	}

	public Set<CottageSuperDeal> getCottageSuperDeal() {
		return cottageSuperDeal;
	}

	public void setCottageSuperDeal(Set<CottageSuperDeal> cottageSuperDeal) {
		this.cottageSuperDeal = cottageSuperDeal;
	}

	public CottageOwner getCottageOwner() {
		return cottageOwner;
	}

	public void setCottageOwner(CottageOwner cottageOwner) {
		this.cottageOwner = cottageOwner;
	}

	public int getPricePerDay() {
		return this.pricePerDay;
	}

	
	
	
}