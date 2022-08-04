package com.example.fisherbooker.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CottageSuperDeal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	private int discountedPrice;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private int capacity;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cottage_id", nullable = false)
	public Cottage cottage;
	
	@ManyToMany
	Set<CottageOption> options = new HashSet<CottageOption>();

	public CottageSuperDeal() {
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

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
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

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}

	@Override
	public String toString() {
		return "CottageSuperDeal [id=" + id + ", startDate=" + startDate + ", discountedPrice=" + discountedPrice
				+ ", endDate=" + endDate + ", capacity=" + capacity + ", cottage=" + cottage + "]";
	}

}