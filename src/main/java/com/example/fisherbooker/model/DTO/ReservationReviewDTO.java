package com.example.fisherbooker.model.DTO;

import com.example.fisherbooker.model.AdventureReservation;
import com.example.fisherbooker.model.AdventureReservationReview;
import com.example.fisherbooker.model.CottageReservation;
import com.example.fisherbooker.model.CottageReservationReview;
import com.example.fisherbooker.model.ReservationType;
import com.example.fisherbooker.model.ShipReservation;
import com.example.fisherbooker.model.ShipReservationReview;

public class ReservationReviewDTO {
	private String content;
	private Boolean badReview;
	private Boolean didntAppear;
	private ReservationType type;
	private Long reservationId;

	public ReservationReviewDTO() {
		super();
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

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public ReservationType getType() {
		return type;
	}

	public void setType(ReservationType type) {
		this.type = type;
	}
	
	public CottageReservationReview toCottageReview() {
		CottageReservationReview review = new CottageReservationReview();
		review.setBadReview(badReview);
		review.setContent(content);
		review.setDidntAppear(didntAppear);
		review.setCottageReservation(new CottageReservation(reservationId));
		return review;
	}
	
	public ShipReservationReview toShipReview() {
		ShipReservationReview review = new ShipReservationReview();
		review.setBadReview(badReview);
		review.setContent(content);
		review.setDidntAppear(didntAppear);
		review.setShipReservation(new ShipReservation(reservationId));
		return review;
	}

	public AdventureReservationReview toAdventureReview() {
		AdventureReservationReview review = new AdventureReservationReview();
		review.setBadReview(badReview);
		review.setContent(content);
		review.setDidntAppear(didntAppear);
		review.setAdventureReservation(new AdventureReservation(reservationId));
		return review;
	}

}
