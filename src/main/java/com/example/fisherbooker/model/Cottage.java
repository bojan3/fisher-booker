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
@Table(name = "cottage")
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

	@OneToOne(cascade=CascadeType.ALL)
	public Address address;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Room> rooms;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<Rule> rules;
	
	@JsonManagedReference
	@OneToMany(mappedBy="cottage", fetch = FetchType.EAGER)
	public Set<CottageSuperDeal> cottageSuperDeal;
	
	@OneToOne(cascade=CascadeType.ALL)
	public AvailabilityPeriod availabilityPeriod;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<CottagePicture> cottagePictures;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<CottageReservation> cottageReservation;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<CottageOption> cottageOptions;
	
	@JsonIgnore
	@ManyToOne
	private CottageOwner cottageOwner;

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

	public List<Room> getRoom() {
		return rooms;
	}

	public void setRoom(List<Room> room) {
		this.rooms = room;
	}

	public Set<Rule> getRule() {
		return rules;
	}

	public void setRule(Set<Rule> rule) {
		this.rules = rule;
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