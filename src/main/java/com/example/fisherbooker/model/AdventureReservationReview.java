package com.example.fisherbooker.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("ADVENTURE")
public class AdventureReservationReview extends ReservationReview {

	@OneToOne
	private AdventureReservation adventureReservation;

	public AdventureReservationReview() {
		super();
	}

	//public AdventureReservationReview(ReservationReview rr) {
	//	this.answered = rr.getAnswered();
	//	this.
	//}

	public AdventureReservation getAdventureReservation() {
		return adventureReservation;
	}

	public void setAdventureReservation(AdventureReservation adventureReservation) {
		this.adventureReservation = adventureReservation;
	}
}