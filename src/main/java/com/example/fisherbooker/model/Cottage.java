package com.example.fisherbooker.model;

import java.util.HashSet;
import java.util.Iterator;
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
import javax.persistence.Version;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	
	private Boolean isDeleted = false;

	@OneToOne(cascade = CascadeType.ALL)
	public Address address;

	@OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Room> rooms = new HashSet<Room>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	public Set<Rule> rules = new HashSet<Rule>();

	@OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<CottageSuperDeal> cottageSuperDeals = new HashSet<CottageSuperDeal>();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public AvailabilityPeriod availabilityPeriod = new AvailabilityPeriod();

	@OneToMany(mappedBy = "cottage", fetch = FetchType.EAGER)
	public Set<CottageImage> cottageImages = new HashSet<CottageImage>();

	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "cottage", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	public Set<CottageReservation> cottageReservations = new HashSet<CottageReservation>();

	// @JsonIgnore
	// @OneToMany(mappedBy = "cottage", cascade = CascadeType.PERSIST, fetch =
	// FetchType.EAGER)
	// public Set<CottageComplaint> cottageComplaints;

	@OneToMany(mappedBy = "cottage", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
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

	@Version
	@Column(columnDefinition = "integer DEFAULT 0", nullable = false)
	private Integer version;

	public Cottage() {
		this.isDeleted=false;
	}

	public Cottage(Long id) {
		this.id = id;
		this.isDeleted=false;

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
		this.rooms.clear();
		for (Room r : rooms) {
			r.setCottage(this);
			this.rooms.add(r);
		}
	}

	public Set<Rule> getRules() {
		return rules;
	}

	public void setRules(Set<Rule> rules) {
		this.rules.clear();
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

	public Set<CottageImage> getCottageImages() {
		return cottageImages;
	}

	public void setCottageImages(Set<CottageImage> cottageImages) {
		this.cottageImages = cottageImages;
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
		this.cottageOptions.clear();
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

//	public Integer getVersion() {
//		return version;
//	}
//
//	public void setVersion(Integer version) {
//		this.version = version;
//	}

	public void addReservation(CottageReservation newReservation) {
		if (newReservation == null)
			return;
		if (this.cottageReservations == null)
			this.cottageReservations = new java.util.HashSet<CottageReservation>();
		if (!this.cottageReservations.contains(newReservation))
			this.cottageReservations.add(newReservation);
	}

	public void addSuperDeal(CottageSuperDeal newSuperDeal) {
		if (newSuperDeal == null)
			return;
		if (this.cottageSuperDeals == null)
			this.cottageSuperDeals = new java.util.HashSet<CottageSuperDeal>();
		if (!this.cottageSuperDeals.contains(newSuperDeal))
			this.cottageSuperDeals.add(newSuperDeal);
	}
	@Override
	public String toString() {
		return "Cottage [id=" + id + ", name=" + name + ", description=" + description + ", pricePerDay=" + pricePerDay
				+ ", averageMark=" + averageMark + ", cottageOwner=" + cottageOwner + ", client=" + client
				+ ", version=" + version + "]";
	}

	public boolean Deleted() {
		return this.isDeleted;
	}

	public boolean isOwnerDeleted() {
			return this.getCottageOwner().getAccount().isDeleted();
	}

	public void setIsDeleted(boolean b) {
			this.isDeleted = b;
		
	}
	
	
}

	public void addImage(CottageImage newImage) {
		if (newImage == null)
			return;
		if (this.cottageImages == null)
			this.cottageImages = new java.util.HashSet<CottageImage>();
		if (!this.cottageImages.contains(newImage))
			this.cottageImages.add(newImage);
	}

}
