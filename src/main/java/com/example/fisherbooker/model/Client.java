package com.example.fisherbooker.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	public Account account;
	
	@OneToMany
	public Set<ShipReservation> shipReservation;
	
	@OneToMany
	public Set<CottageReservation> cottageReservation;

	@OneToMany
	public Set<AdventureReservation> adventureReservation;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
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

	public void setShipReservation(java.util.Set<ShipReservation> newShipReservation) {
		removeAllShipReservation();
		for (java.util.Iterator iter = newShipReservation.iterator(); iter.hasNext();)
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

	public void setAdventureReservation(java.util.Set<AdventureReservation> newAdventureReservation) {
		removeAllAdventureReservation();
		for (java.util.Iterator iter = newAdventureReservation.iterator(); iter.hasNext();)
			addAdventureReservation((AdventureReservation) iter.next());
	}

	public void addAdventureReservation(AdventureReservation newAdventureReservation) {
		if (newAdventureReservation == null)
			return;
		if (this.adventureReservation == null)
			this.adventureReservation = new java.util.HashSet<AdventureReservation>();
		if (!this.adventureReservation.contains(newAdventureReservation))
			this.adventureReservation.add(newAdventureReservation);
	}

	public void removeAdventureReservation(AdventureReservation oldAdventureReservation) {
		if (oldAdventureReservation == null)
			return;
		if (this.adventureReservation != null)
			if (this.adventureReservation.contains(oldAdventureReservation))
				this.adventureReservation.remove(oldAdventureReservation);
	}

	public void removeAllAdventureReservation() {
		if (adventureReservation != null)
			adventureReservation.clear();
	}

	public Account getAccount() {
		// TODO Auto-generated method stub
		return this.account;
	}


	

}