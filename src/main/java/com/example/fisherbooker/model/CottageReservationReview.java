package com.example.fisherbooker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CottageReservationReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
	private Boolean badReview;
	private Boolean didntAppear;

	@OneToOne
	private CottageReservation cottageReservation;

	public CottageReservationReview() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getBadReview() {
		return badReview;
	}

	public void setBadReview(Boolean badReview) {
		this.badReview = badReview;
	}

	public Boolean getDidntAppear() {
		return didntAppear;
	}

	public void setDidntAppear(Boolean didntAppear) {
		this.didntAppear = didntAppear;
	}

	public CottageReservation getCottageReservation() {
		return cottageReservation;
	}

	public void setCottageReservation(CottageReservation cottageReservation) {
		this.cottageReservation = cottageReservation;
	}

}
