package com.example.fisherbooker.model;

import java.util.HashSet;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "adventure")
public class Adventure {
	public Adventure() {
		super();
	}

	public Adventure(String name, String adress, String description, AdventurePicture pic, int capacity,
			AdventureFastReservation afr, Rule rule, FishingEquipment fe, AdventureOption ao, float CancelRate) {
	}

	public Adventure(Long realEstateId) {
		this.id = id;
		this.isDeleted = false;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(length = 350)
	private String description;

	@Column
	private int capacity;

	@Column
	private int price;

	@Column
	private float cancelRate;
	
	private String imagePath;

	
	private Boolean isDeleted = false;

	
	@OneToMany(mappedBy = "adventure", fetch = FetchType.EAGER)
	public Set<AdventureImage> adventureImages = new HashSet<AdventureImage>();

	@OneToMany(mappedBy = "adventure", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<AdventureOption> adventureOption = new HashSet<AdventureOption>();
	
	@ManyToOne
	public Address address;

	@JsonIgnore
	@OneToMany(mappedBy = "adventure", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<AdventurePicture> adventurePicture = new HashSet<AdventurePicture>();

	@JsonIgnore
	@OneToMany(mappedBy = "adventure", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<AdventureFastReservation> adventureFastReservation = new HashSet<AdventureFastReservation>();

	@JsonIgnore
	@OneToMany(mappedBy = "adventure", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public Set<AdventureReservation> adventureReservation = new HashSet<AdventureReservation>();

	@JsonIgnore
	@OneToMany(/*mappedBy = "adventure", */cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Set<Rule> rule = new HashSet<Rule>();

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "instructor_id", nullable = false)
	public FishingInstructor fishingInstructor;

	@JsonIgnore
	@OneToMany(mappedBy = "adventure", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<AdventureReview> adventureReviews = new HashSet<AdventureReview>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "adventure", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public Set<FishingEquipment> fishingEqupiment = new HashSet<FishingEquipment>();
	
	@Version
	@Column(columnDefinition = "integer DEFAULT 0", nullable = false)
	private Integer version;
	
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
		return this.cancelRate;
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

//	public java.util.Set<AdventurePicture> getAdventurePicture() {
//		return adventurePicture;
//	}

//	public void setAdventurePicture(java.util.Set<AdventurePicture> adventurePicture) {
//		this.adventurePicture = adventurePicture;
//	}

//	public Set<AdventureFastReservation> getAdventureFastReservation() {
//		return adventureFastReservation;
//	}

//	public void setAdventureFastReservation(Set<AdventureFastReservation> adventureFastReservation) {
//		this.adventureFastReservation = adventureFastReservation;
//	}

	
	public Set<FishingEquipment> getEquipment() {
		return fishingEqupiment;
	}

	public void setEquipment(Set<FishingEquipment> fie) {
		this.fishingEqupiment = fie;
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

	@Override
	public String toString() {
		return "Adventure [id=" + id + ", name=" + name + ", description=" + description + ", capacity=" + capacity
				+ ", price=" + price + ", cancelRate=" + cancelRate + ", adventureOption=" + adventureOption
				+ ", address=" + address + ", adventurePicture=" + adventurePicture + ", adventureFastReservation="
				+ adventureFastReservation + ", rule=" + rule + ", adventureReservation=" + adventureReservation
				+ ", fishingInstructor=" + fishingInstructor + "]";
	}

	public void removeAdventureReservation(AdventureReservation oldAdventureReservation) {
		if (oldAdventureReservation == null)
			return;
		if (this.adventureReservation != null)
			if (this.adventureReservation.contains(oldAdventureReservation)) {
				this.adventureReservation.remove(oldAdventureReservation);
				// oldAdventure.setFishingInstructor((FishingInstructor) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllAdventureReservations() {
		if (adventureReservation != null) {
			AdventureReservation oldAdventureReservation;
			for (java.util.Iterator iter = getIteratorAdventureReservation(); iter.hasNext();) {
				oldAdventureReservation = (AdventureReservation) iter.next();
				iter.remove();
				// oldAdventureReservation.setFishingInstructor((FishingInstructor) null);
			}
		}
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorAdventureReservation() {
		if (adventureReservation == null)
			adventureReservation = new java.util.HashSet<AdventureReservation>();
		return adventureReservation.iterator();
	}

	public boolean getIsDeleted() {
		return this.isDeleted;
	}
	
	public void setIsDeleted(Boolean b) {
			this.isDeleted = b;
	}

	public void addImage(AdventureImage newImage) {
		// TODO Auto-generated method stub
		
	}

	public void addReservation(AdventureReservation newReservation) {
		if (newReservation == null)
			return;
		if (this.adventureReservation == null)
			this.adventureReservation = new java.util.HashSet<AdventureReservation>();
		if (!this.adventureReservation.contains(newReservation))
			this.adventureReservation.add(newReservation);
		
	}

	
	

}