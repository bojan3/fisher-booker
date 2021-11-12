package com.example.fisherbooker.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class CottageReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date startDate;
	private Date endDate;
	private int price;
	private int duration;
	private int capacity;
	@ManyToMany
	private Set<CottageOption> cottageOption;

	@ManyToOne
	public Cottage cottage;

	/*
	 * public Cottage getCottage() { return cottage; }
	 * 
	 * public void setCottage(Cottage newCottage) { if (this.cottage == null ||
	 * !this.cottage.equals(newCottage)) { if (this.cottage != null) { Cottage
	 * oldCottage = this.cottage; this.cottage = null;
	 * oldCottage.removeCottageReservation(this); } if (newCottage != null) {
	 * this.cottage = newCottage; this.cottage.addCottageReservation(this); } } }
	 */

}