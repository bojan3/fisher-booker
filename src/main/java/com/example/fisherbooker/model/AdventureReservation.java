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

@Entity
public class AdventureReservation {
	public AdventureReservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date startTime;
	
	//@Column
	//private Date endDate;
	
	@Column
	private int duration;

	@Column
	private int capacity;
	
	@Column
	private float cancelRate;
	
	@OneToMany
	private Set<AdventureOption> adventureOption;
	
	
	@Column
	private int price;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	public Client client;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
//	@JoinColumn(name="adventure")
	public Adventure adventure;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public Date getStartDate() {
//		return startDate;
//	}
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}
//	public Date getEndDate() {
//		return endDate;
//	}
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}
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
	
	@Override
	public String toString() {
		return "AdventureReservation [id=" + id + ", startDate=" + startTime + ", duration="
				+ duration + ", capacity=" + capacity + ", adventureOption=" + adventureOption + ", price=" + price
				+ "]";
	}

}