package com.example.fisherbooker.model;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.fisherbooker.model.DTO.ReservationDetailsDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShipReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date startDate;
	private Date endDate;
	private int price;
	private int capacity;
	private boolean deleted;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "shreservation_reservation_supportdata", joinColumns = @JoinColumn(name = "shreservation_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "suppdata_id2", referencedColumnName = "id"))
	private ShipReservationSupportData reservationsd;

	@ManyToMany(fetch = FetchType.EAGER)
	public Set<ShipOption> shipOption;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ship_id", nullable = false)
	public Ship ship;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	public Client client;

	public ShipReservation() {
		super();
		this.deleted = false;
	}
	
	public ShipReservation(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShipReservationSupportData getReservationsd() {
		return reservationsd;
	}

	public void setReservationsd(ShipReservationSupportData reservationsd) {
		this.reservationsd = reservationsd;
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

	public Set<ShipOption> getShipOption() {
		return shipOption;
	}

	public void setShipOption(Set<ShipOption> shipOption) {
		this.shipOption = shipOption;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public ReservationDetailsDTO toDTO() {
		ReservationDetailsDTO dto = new ReservationDetailsDTO();
		dto.setId(id);
		dto.setCapacity(capacity);
		dto.setName(ship.getName());
		dto.setEndDate(endDate);
		dto.setStartDate(startDate);
		dto.setPrice(price);
		dto.setOptions(shipOption.toString());
		dto.setUserInfo(client.toString());
		dto.setClientId(client.getId());
		dto.setRealEstateId(ship.getId());
		return dto;
	}

	public void addOption(ShipOption newShipOption) {
		if (newShipOption == null)
			return;
		if (this.shipOption == null)
			this.shipOption = new java.util.HashSet<ShipOption>();
		if (!this.shipOption.contains(newShipOption))
			this.shipOption.add(newShipOption);
	}
	


	@Override
	public String toString() {
		return "ShipReservation [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price
				+ ", capacity=" + capacity + ", deleted=" + deleted + ", shipOption=" + shipOption + ", ship=" + ship
				+ ", client=" + client + "]";
	}

}