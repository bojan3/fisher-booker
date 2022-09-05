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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.fisherbooker.model.DTO.ReservationDetailsDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CottageReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date startDate;
	private Date endDate;
	private int price;
	private int capacity;
	private boolean deleted;

	
    //@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToOne
	(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinTable(name = "creservation_reservation_supportdata", joinColumns = @JoinColumn(name = "creservation_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "suppdata_id3", referencedColumnName = "id"))
	private CottageReservationSupportData reservationsd;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<CottageOption> cottageOption;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cottage_id")
	public Cottage cottage;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	public Client client;

	public CottageReservation() {
		super();
		this.deleted = false;
	}

	public CottageReservation(CottageSuperDeal cottageSuperDeal, Client client) {
		super();
		this.startDate = cottageSuperDeal.getStartDate();
		this.endDate = cottageSuperDeal.getEndDate();
		this.price = cottageSuperDeal.getDiscountedPrice();
		this.capacity = cottageSuperDeal.getCapacity();
		this.deleted = false;
		this.cottage = cottageSuperDeal.getCottage();
		this.client = client;
		this.cottageOption = cottageSuperDeal.getOptionsCopy();
		this.reservationsd = new CottageReservationSupportData();
	}
	
	public CottageReservation(Long id) {
		super();
		this.id = id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Set<CottageOption> getCottageOption() {
		return cottageOption;
	}

	public void setCottageOption(Set<CottageOption> cottageOption) {
		this.cottageOption = cottageOption;
	}

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}
	
	public void setCottageSupportData(CottageReservationSupportData child) {
	    if (child == null) {
	        if (this.reservationsd != null) {
	            this.reservationsd.setCottageReservation(null);
	        }
	    }
	    else {
	        child.setCottageReservation(this);
	    }
	    this.reservationsd = child;
	}
	
	public ReservationDetailsDTO toDTO() {
		ReservationDetailsDTO dto = new ReservationDetailsDTO();
		dto.setId(id);
		dto.setCapacity(capacity);
		dto.setName(cottage.getName());
		dto.setEndDate(endDate);
		dto.setStartDate(startDate);
		dto.setPrice(price);
		dto.setOptions(cottageOption.toString());
		dto.setUserInfo(client.toString());
		dto.setClientId(client.getId());
		dto.setRealEstateId(cottage.getId());
		return dto;
	}

	public void addOption(CottageOption newCottageOption) {
		if (newCottageOption == null)
			return;
		if (this.cottageOption == null)
			this.cottageOption = new java.util.HashSet<CottageOption>();
		if (!this.cottageOption.contains(newCottageOption))
			this.cottageOption.add(newCottageOption);
	}

	public void finalize() throws Throwable {
		this.setCottageSupportData(null);
		System.gc();
	} 
	
	
	@Override
	public String toString() {
		return "CottageReservation [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price
				+ ", capacity=" + capacity + "]";
	}

}