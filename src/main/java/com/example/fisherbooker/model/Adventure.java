package com.example.fisherbooker.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="adventure")
public class Adventure {
	public Adventure() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Adventure(String name,String adress, String description,AdventurePicture pic,int capacity, AdventureFastReservation afr ,Rule rule, FishingEquipment fe, AdventureOption ao, float CancelRate)
		{}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length=30, nullable=false)
	private String name;
	@Column(length=350)
	private String description;
	
	private int capacity;
	@Column
	private int price;
	private float cancelRate;

	@OneToMany
	public Set<AdventureOption> adventureOption;
	
	@ManyToOne
	public Address address;
	
	@OneToMany
	public java.util.Set<AdventurePicture> adventurePicture;
	
	@OneToMany
	public Set<AdventureFastReservation> adventureFastReservation;
	
	@OneToMany
	public Set<Rule> rule;
	
	@OneToMany
	public Set<AdventureReservation> adventureReservation;
	
	@ManyToOne
	@JoinColumn(name="account", nullable=false)
	public FishingInstructor fishingInstructor;
	
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getCancelRate() {
		return cancelRate;
	}

	public void setCancelRate(float cancelRate) {
		this.cancelRate = cancelRate;
	}

	public Set<AdventureOption> getFishingOption() {
		return adventureOption;
	}

	public void setFishingOption(Set<AdventureOption> fishingOption) {
		this.adventureOption = fishingOption;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public java.util.Set<AdventurePicture> getAdventurePicture() {
		return adventurePicture;
	}

	public void setAdventurePicture(java.util.Set<AdventurePicture> adventurePicture) {
		this.adventurePicture = adventurePicture;
	}

	public Set<AdventureFastReservation> getAdventureFastReservation() {
		return adventureFastReservation;
	}

	public void setAdventureFastReservation(Set<AdventureFastReservation> adventureFastReservation) {
		this.adventureFastReservation = adventureFastReservation;
	}

	public Set<Rule> getRule() {
		return rule;
	}

	public void setRule(Set<Rule> rule) {
		this.rule = rule;
	}

	public Set<AdventureReservation> getAdventureReservation() {
		return adventureReservation;
	}

	public void setAdventureReservation(Set<AdventureReservation> adventureReservation) {
		this.adventureReservation = adventureReservation;
	}

	public FishingInstructor getFishingInstructor() {
		return fishingInstructor;
	}

	public void setFishingInstructor(FishingInstructor fishingInstructor) {
		this.fishingInstructor = fishingInstructor;
	}


}