package com.example.fisherbooker.model;

import java.util.Date;
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

import com.example.fisherbooker.model.DTO.ReservationDetailsDTO;
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
	private float cancelRate;
	private int duration;
	private boolean deleted;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "areservation_reservation_supportdata", joinColumns = @JoinColumn(name = "areservation_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "suppdata_id1", referencedColumnName = "id"))
	private AdventureReservationSupportData reservationsd;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "adventure_id", nullable = false)
	public Adventure adventure;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	public Client client;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<AdventureOption> adventureOption;

	public AdventureReservation() {
		super();
	}

	public boolean add(AdventureOption e) {
		return adventureOption.add(e);
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

	public float getCancelRate() {
		return cancelRate;
	}

	public void setCancelRate(float cancelRate) {
		this.cancelRate = cancelRate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public AdventureReservationSupportData getReservationsd() {
		return reservationsd;
	}

	public void setReservationsd(AdventureReservationSupportData reservationsd) {
		this.reservationsd = reservationsd;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "AdventureReservation [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", capacity="
				+ capacity + ", price=" + price + ", deleted=" + deleted + ", adventure=" + adventure + ", client="
				+ client + ", adventureOption=" + adventureOption + "]";
	}

	public Address getAddress() {
		// TODO Auto-generated method stub
		return this.getAdventure().getAddress();
	}

	public ReservationDetailsDTO toDTO() {
		ReservationDetailsDTO dto = new ReservationDetailsDTO();
		dto.setId(id);
		dto.setCapacity(capacity);
		dto.setName(adventure.getName());
		dto.setEndDate(endDate);
		dto.setStartDate(startDate);
		dto.setPrice(price);
		dto.setOptions(adventureOption.toString());
		dto.setUserInfo(client.toString());
		dto.setClientId(client.getId());
		dto.setRealEstateId(adventure.getId());
		return dto;
	}

	public AdventureReservation(Long id) {
		super();
		this.id = id;
	}

	public void addOption(AdventureOption option) {
		if (option == null)
			return;
		if (this.adventureOption == null)
			this.adventureOption = new java.util.HashSet<AdventureOption>();
		if (!this.adventureOption.contains(option))
			this.adventureOption.add(option);
	}

}