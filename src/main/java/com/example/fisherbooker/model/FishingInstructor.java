package com.example.fisherbooker.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class FishingInstructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToMany(mappedBy = "instructorSubscriptions")
	private Set<Client> client;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	@OneToOne
	public Account account;

	@Column(length=350)
	private String biography;

	@OneToMany(mappedBy = "fishingInstructor")
	public java.util.Set<Adventure> adventure;

	public FishingInstructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** @pdGenerated default getter */
	public java.util.Set<Adventure> getAdventure() {
		if (adventure == null)
			adventure = new java.util.HashSet<Adventure>();
		return adventure;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorAdventure() {
		if (adventure == null)
			adventure = new java.util.HashSet<Adventure>();
		return adventure.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newAdventure
	 */
	public void setAdventure(java.util.Set<Adventure> newAdventure) {
		removeAllAdventure();
		for (java.util.Iterator iter = newAdventure.iterator(); iter.hasNext();)
			addAdventure((Adventure) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newAdventure
	 */
	public void addAdventure(Adventure newAdventure) {
		if (newAdventure == null)
			return;
		if (this.adventure == null)
			this.adventure = new java.util.HashSet<Adventure>();
		if (!this.adventure.contains(newAdventure)) {
			this.adventure.add(newAdventure);
			newAdventure.setFishingInstructor(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldAdventure
	 */
	public void removeAdventure(Adventure oldAdventure) {
		if (oldAdventure == null)
			return;
		if (this.adventure != null)
			if (this.adventure.contains(oldAdventure)) {
				this.adventure.remove(oldAdventure);
				oldAdventure.setFishingInstructor((FishingInstructor) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllAdventure() {
		if (adventure != null) {
			Adventure oldAdventure;
			for (java.util.Iterator iter = getIteratorAdventure(); iter.hasNext();) {
				oldAdventure = (Adventure) iter.next();
				iter.remove();
				oldAdventure.setFishingInstructor((FishingInstructor) null);
			}
		}
	}

}