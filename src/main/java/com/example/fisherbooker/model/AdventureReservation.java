package com.example.fisherbooker.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AdventureReservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date startDate;
	private Date endDate;
	private int capacity;
	private int price;

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "adventure_id", nullable = false)
	public Adventure adventure;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	public Client client;

	@ManyToMany
	private Set<AdventureOption> adventureOption;

	public AdventureReservation() {
		super();
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getCancelRate() {
		return duration;
	}
	public void setCancelRate(float duration) {
		this.cancelRate = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Set<AdventureOption> getAdventureOption() {
		return adventureOption;
	}

	public void setAdventureOption(Set<AdventureOption> adventureOption) {
		this.adventureOption = adventureOption;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Adventure getAdventure() {
		return adventure;
	}

	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "AdventureReservation [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", capacity="
				+ capacity + ", adventure=" + adventure + ", client=" + client + ", adventureOption=" + adventureOption
				+ ", price=" + price + "]";
	}
	public Address getAddress() {
		// TODO Auto-generated method stub
		return this.getAdventure().getAddress();
	}

}