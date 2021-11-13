package com.example.fisherbooker.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@Transient
	private float averageMark;

	@OneToOne
	public Address address;
	
	@OneToMany
	public List<Room> room;
	
	@OneToMany
	public Set<Rule> rule;
	
	@OneToMany(mappedBy="cottage")
	public Set<CottageSuperDeal> cottageSuperDeal;
	
	@OneToOne
	public AvailabilityPeriod availabilityPeriod;
	
	@OneToMany
	public Set<CottagePicture> cottagePicture;
	
	@OneToMany
	public Set<CottageReservation> cottageReservation;
	
	@ManyToMany
	public Set<CottageOption> cottageOptions;

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
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public Set<Rule> getRule() {
		return rule;
	}

	public void setRule(Set<Rule> rule) {
		this.rule = rule;
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
		return cottagePicture;
	}

	public void setCottagePicture(Set<CottagePicture> cottagePicture) {
		this.cottagePicture = cottagePicture;
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

}