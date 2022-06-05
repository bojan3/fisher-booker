package com.example.fisherbooker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CottageOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
	public Account account;

	@OneToMany(mappedBy = "cottageOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Cottage> cottages = new HashSet<Cottage>();

	public CottageOwner() {
		super();
	}

	public CottageOwner(Set<Cottage> cottages, Account account) {
		super();
		this.cottages = cottages;
		this.account = account;
	}

	public Set<Cottage> getCottages() {
		return cottages;
	}

	public void setCottages(Set<Cottage> cottages) {
		this.cottages = cottages;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "CottageOwner [account=" + account + ", cottage=" + cottages + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void removeAllCottage() {
		if (cottages != null) {
			Cottage oldAdventure;
			for (java.util.Iterator iter = getIteratorCottage(); iter.hasNext();) {
				oldAdventure = (Cottage) iter.next();
		      //  oldAdventure.setAvailabilityPeriod(null);
			//	oldAdventure.free();
				iter.remove();
			//	oldAdventure.setFishingInstructor((FishingInstructor) null);
				
			
			}
		
			}
		}
	
	
	public java.util.Iterator getIteratorCottage() {
		if (cottages == null)
			cottages = new java.util.HashSet<Cottage>();
		return cottages.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newAdventure
	 */
	public void setCottage(java.util.Set<Cottage> newCottage) {
		removeAllCottage();
		for (java.util.Iterator iter = newCottage.iterator(); iter.hasNext();)
			addCottage((Cottage) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newAdventure
	 */
	public void addCottage(Cottage newCottage) {
		if (newCottage == null)
			return;
		if (this.cottages == null)
			this.cottages = new java.util.HashSet<Cottage>();
		if (!this.cottages.contains(newCottage)) {
			this.cottages.add(newCottage);
			newCottage.setCottageOwner(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldAdventure
	 */
	public void removeCottage(Cottage oldCottage) {
		if (oldCottage == null)
			return;
		if (this.cottages != null)
			if (this.cottages.contains(oldCottage)) {
				this.cottages.remove(oldCottage);
				oldCottage.setCottageOwner((CottageOwner) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllCottages() {
		if (cottages != null) {
			Cottage oldCottage;
			for (java.util.Iterator iter = getIteratorCottage(); iter.hasNext();) {
				oldCottage = (Cottage) iter.next();
				iter.remove();
			//	oldAdventure.setFishingInstructor((FishingInstructor) null);
			}
		}
	}
	
	
	
	
	
	
	
	
	
}