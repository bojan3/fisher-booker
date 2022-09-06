package com.example.fisherbooker.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	public Account account;

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<ShipReservation> shipReservation;

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<CottageReservation> cottageReservation;

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<AdventureReservation> adventureReservation;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "cottage_subscriptions", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "cottage_id"))
	Set<Cottage> cottageSubscriptions;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "ship_subscriptions", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "ship_id"))
	Set<Ship> shipSubscriptions;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "instructor_subscriptions", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "instructor_id"))
	Set<FishingInstructor> instructorSubscriptions;

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Review> reviews;
	
	@Version
	private Long version;
	
	private int penals;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	public Set<CottageComplaint> cottageComplaints;
	
	public Client() {
		super();
		this.penals = 0;
	}

	public java.util.Set<ShipReservation> getShipReservation() {
		if (shipReservation == null)
			shipReservation = new java.util.HashSet<ShipReservation>();
		return shipReservation;
	}

	public java.util.Iterator getIteratorShipReservation() {
		if (shipReservation == null)
			shipReservation = new java.util.HashSet<ShipReservation>();
		return shipReservation.iterator();
	}

	public void setShipReservation(Collection<ShipReservation> shipReservations) {
		removeAllShipReservation();
		for (java.util.Iterator iter = shipReservations.iterator(); iter.hasNext();)
			addShipReservation((ShipReservation) iter.next());
	}

	public void addShipReservation(ShipReservation newShipReservation) {
		if (newShipReservation == null)
			return;
		if (this.shipReservation == null)
			this.shipReservation = new java.util.HashSet<ShipReservation>();
		if (!this.shipReservation.contains(newShipReservation))
			this.shipReservation.add(newShipReservation);
	}

	public void removeShipReservation(ShipReservation oldShipReservation) {
		if (oldShipReservation == null)
			return;
		if (this.shipReservation != null)
			if (this.shipReservation.contains(oldShipReservation))
				this.shipReservation.remove(oldShipReservation);
	}

	public void removeAllShipReservation() {
		if (shipReservation != null)
			shipReservation.clear();
	}

	public java.util.Collection<CottageReservation> getCottageReservation() {
		if (cottageReservation == null)
			cottageReservation = new java.util.HashSet<CottageReservation>();
		return cottageReservation;
	}

	public java.util.Iterator getIteratorCottageReservation() {
		if (cottageReservation == null)
			cottageReservation = new java.util.HashSet<CottageReservation>();
		return cottageReservation.iterator();
	}

	public void setCottageReservation(java.util.Collection<CottageReservation> newCottageReservation) {
		removeAllCottageReservation();
		for (java.util.Iterator iter = newCottageReservation.iterator(); iter.hasNext();)
			addCottageReservation((CottageReservation) iter.next());
	}

	public void addCottageReservation(CottageReservation newCottageReservation) {
		if (newCottageReservation == null)
			return;
		if (this.cottageReservation == null)
			this.cottageReservation = new java.util.HashSet<CottageReservation>();
		if (!this.cottageReservation.contains(newCottageReservation))
			this.cottageReservation.add(newCottageReservation);
	}

	public void removeCottageReservation(CottageReservation oldCottageReservation) {
		if (oldCottageReservation == null)
			return;
		if (this.cottageReservation != null)
			if (this.cottageReservation.contains(oldCottageReservation))
				this.cottageReservation.remove(oldCottageReservation);
	}

	public void removeAllCottageReservation() {
		if (cottageReservation != null)
			cottageReservation.clear();
	}

	public java.util.Set<AdventureReservation> getAdventureReservation() {
		if (adventureReservation == null)
			adventureReservation = new java.util.HashSet<AdventureReservation>();
		return adventureReservation;
	}

	public java.util.Iterator getIteratorAdventureReservation() {
		if (adventureReservation == null)
			adventureReservation = new java.util.HashSet<AdventureReservation>();
		return adventureReservation.iterator();
	}

	public void setAdventureReservation(Collection<AdventureReservation> adventureReservations) {
		removeAllAdventureReservation();
		for (java.util.Iterator iter = adventureReservations.iterator(); iter.hasNext();)
			addAdventureReservation((AdventureReservation) iter.next());
	}

	public void removeAdventureReservation(AdventureReservation oldAdventureReservation) {
		if (oldAdventureReservation == null)
			return;
		if (this.adventureReservation != null)
			if (this.adventureReservation.contains(oldAdventureReservation))
				this.adventureReservation.remove(oldAdventureReservation);
	}

	public void addAdventureReservation(AdventureReservation newAdventureReservation) {
		if (newAdventureReservation == null)
			return;
		if (this.adventureReservation == null)
			this.adventureReservation = new java.util.HashSet<AdventureReservation>();
		if (!this.adventureReservation.contains(newAdventureReservation))
			this.adventureReservation.add(newAdventureReservation);
	}

	public void removeAllAdventureReservation() {
		if (adventureReservation != null)
			adventureReservation.clear();
	}

	public Account getAccount() {
		return this.account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Cottage> getCottageSubscriptions() {
		return cottageSubscriptions;
	}

	public void setCottageSubscriptions(Set<Cottage> cottageSubscriptions) {
		this.cottageSubscriptions = cottageSubscriptions;
	}

	public Set<Ship> getShipSubscriptions() {
		return shipSubscriptions;
	}

	public void setShipSubscriptions(Set<Ship> shipSubscriptions) {
		this.shipSubscriptions = shipSubscriptions;
	}

	public Set<FishingInstructor> getInstructorSubscriptions() {
		return instructorSubscriptions;
	}

	public void setInstructorSubscriptions(Set<FishingInstructor> instructorSubscriptions) {
		this.instructorSubscriptions = instructorSubscriptions;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setCottageReservation(Set<CottageReservation> cottageReservation) {
		this.cottageReservation = cottageReservation;
	}
	
	public int getPenals() {
		return this.penals;
	}
	public void setPenals(int penals) {
		this.penals=penals;
	}
	
	

//	@Override
//	public String toString() {
//		return "Client [id=" + id + ", account=" + account + ", shipReservation=" + shipReservation
//				+ ", cottageReservation=" + cottageReservation + ", adventureReservation=" + adventureReservation
//				+ ", cottageSubscriptions=" + cottageSubscriptions + ", shipSubscriptions=" + shipSubscriptions
//				+ ", instructorSubscriptions=" + instructorSubscriptions + "]";
//	}
	
	@Override
	public String toString() {
		return account.getName() + " " + account.getLastName() + ", " + account.getEmail() + ", " + account.getPhoneNumber();
	}
}